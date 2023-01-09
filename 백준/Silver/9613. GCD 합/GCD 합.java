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
	
	// main
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 0; tc < T; tc++) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			for(int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			
			long ans = 0;
			for(int i = 0; i < n-1; i++) {
				for(int j = i+1; j < n; j++) {
					ans += GCD(arr[i], arr[j]);
				}
			}
			
			System.out.println(ans);
		}
	}
}