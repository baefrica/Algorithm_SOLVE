import java.util.Scanner;

public class Main {
	static int[] memo;
	// n번째 피보나치 수를 구하는 함수
	public static int fibonacci(int n) {
		if(n == 0) {
			memo[n] = 0;
		}
		else if(n == 1) {
			memo[n] = 1;
		}
		else {
			if(memo[n] == 0) {
				memo[n] = fibonacci(n-1) + fibonacci(n-2);
			}
		}
		
		return memo[n];
	}
	
	// main
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();	// n은 20보다 작거나 같은 자연수 또는 0
		
		memo = new int[n+1];
			
		System.out.println(fibonacci(n));
	}
}