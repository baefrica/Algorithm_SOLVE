import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String N = sc.nextLine();
		int num = Integer.parseInt(N);
		
		int cnt = 0;
		int combo9 = 0;
		int multi10 = 9;
		int sum = 0;
		for(int i = 1; i <= 9; i++) {
			if( N.length() == i ) {
				sum += ( num - combo9 ) * i;
				cnt = sum;
				break;
			}
			else {
				sum += ( multi10* i );
				combo9 += multi10;
				multi10 *= 10;
			}
		}
		
		System.out.println(cnt);
	}
}