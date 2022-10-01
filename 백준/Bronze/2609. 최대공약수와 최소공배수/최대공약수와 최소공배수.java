import java.util.Scanner;

public class Main {
	// 최대 공약수
	public static int divMax(int a, int b) {
		int M = Math.max(a, b);
		int m = Math.min(a, b);
		int ans = 0;
		
		for(int i = m; i > 0; i--) {
			// 둘 중 작은 수의 약수이면서
			if(m % i == 0) {
				// 둘 중 큰 수의 약수이어야한다
				if(M % i == 0) {
					// i 가 최대 공약수이다
					ans = i;
					break;
				}
			}
		}
		
		return ans;
	}
	
	// 최소 공배수
	public static int multiMin(int a, int b) {
		int M = Math.max(a, b);
		int m = Math.min(a, b);
		int k = 1;
		int ans = 0;
		
		while(true) {
			if((M * k) % m == 0) {
				ans = (M * k);
				break;
			}
			else {
				k++;
			}
		}
		
		return ans;
	}
	
	// main
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		System.out.println(divMax(A, B));
		System.out.println(multiMin(A, B));
	}
}