import java.util.Scanner;

public class Main {
	static int C;
	
	// 분할 정복 기법을 사용한 거듭 제곱 함수
	public static long power(int x, int n) {
		if(n == 1) {
			return x % C;
		}
		
		long y = 0;
		// 짝수번 거듭제곱
		if(n % 2 == 0) {
			y = power(x, n/2);
			return (y * y) % C;
		}
		// 홀수번 거듭제곱
		else {
			y = power(x, (n-1)/2);
			return (((y * y) % C) * x) % C;
		}
	}
	
	// main
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		C = sc.nextInt();
		
//		System.out.println(power(A, B) % C);
		System.out.println(power(A, B));
	}	// main 끝
}