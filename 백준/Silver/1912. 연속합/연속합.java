import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();	// (1 ≤ N ≤ 100,000)
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		int[] dp = new int[N];		// 합의 최적해 저장해주는 배열
		dp[0] = arr[0];
		
		int max = dp[0];
		
		// 계속 더해가는 게 더 크냐 vs 지금부터 새로 시작하는게 낫냐
		for(int i = 1; i < N; i++) {
			// 더 나은 최적해를 저장
			dp[i] = Math.max(dp[i-1] + arr[i], arr[i]);
			// 최댓값 갱신
			max = Math.max(dp[i], max);
		}

//		System.out.println(Arrays.toString(dp));
		System.out.println(max);
	}
}

//# input :
//10
//10 -4 3 1 5 6 -35 12 21 -1

//10
//2 1 -4 3 4 -4 6 5 -5 1

//5
//-1 -2 -3 -4 -5

//# output :
//33
//
//14
//
//-1
