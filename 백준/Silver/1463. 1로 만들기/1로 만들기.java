import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		// N 이 3으로 나누어 떨어지면, 3으로 나눈다.
		// N 이 2로 나누어 떨어지면, 2로 나눈다.
		// 1을 뺀다.
		
		int[] dp = new int[N+1];
		dp[0] = 0;
		dp[1] = 0;
		
		for(int i = 2; i <= N; i++) {
			dp[i] = dp[i-1] + 1;
			
			if(i % 3 == 0) {
				dp[i] = Math.min(dp[i], dp[i/3]+1);
			}
			
			if(i % 2 == 0) {
				dp[i] = Math.min(dp[i], dp[i/2]+1);
			}
		}
		
		System.out.println(dp[N]);
	}
}

//# input :
//2
//
//10
//
//# output :
//1
//
//3
