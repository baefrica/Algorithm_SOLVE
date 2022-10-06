import java.util.Scanner;

public class Main {
	static int zeroCnt;
	static int oneCnt;
	static int[] memo;
	
	// N번째 피보나치 수를 구하는 함수
	public static int fibonacci(int n) {
		if(n == 0) {
			zeroCnt++;
			memo[n] = 0;
		}
		else if(n == 1) {
			oneCnt++;
			memo[n] = 1;
		}
		else {
			// 누적합
			oneCnt += memo[n];
			zeroCnt += memo[n-1];
			
			if(memo[n] == 0) {
				memo[n] = fibonacci(n-1) + fibonacci(n-2);
			}
		}
		
		return memo[n];
	}
	
	// main
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 0; tc < T; tc++) {
			int N = sc.nextInt();	// N은 40보다 작거나 같은 자연수 또는 0
			memo = new int[N+1];
			
			zeroCnt = 0;
			oneCnt = 0;
			fibonacci(N);
			
			System.out.println(zeroCnt + " " + oneCnt);
		}
	}
}

//# input :
//3
//0
//1
//3

//2
//6
//22

//# output :
//1 0
//0 1
//1 2
//
//5 8
//10946 17711
