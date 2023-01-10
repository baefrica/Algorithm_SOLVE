import java.util.Scanner;

public class Main {
	// GCD (최대공약수)
	public static int GCD(int a, int b) {
		if( b == Math.max(a, b) ) {
			int tmp = a;
			a = b;
			b = tmp;
		}
		
		while( a % b != 0) {
			int tmp = (a % b);
			a = b;
			b = tmp;
		}
		
		return b;
	}
	
	// LCM (최소공배수)
	public static long LCM(int a, int b) {
		return ((long) a * b) / GCD(a, b);
	}
	
	// main
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        for(int tc = 0; tc < n; tc++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

           System.out.println( LCM(a, b) );
        }
    }
}
