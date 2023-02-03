import java.util.Scanner;

public class Main {
	static long[] memo;

	// n번째 피보나치 수를 구하는 함수
	public static long fibo(int n) {
		if (n >= 2 && memo[n] == 0) {
			memo[n] = fibo(n - 1) + fibo(n - 2);
		}

		return memo[n];
	}

	// main
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(); // n은 45보다 작거나 같은 자연수
		memo = new long[n + 1];
		memo[1] = 1;

		System.out.println(fibo(n));
	}
}