import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int stair = sc.nextInt();		// 300 이하의 자연수
		int[] point = new int[stair];		// 점수 배열
		for(int i = 0; i < stair; i++) {
			point[i] = sc.nextInt();		// 계단에 쓰여 있는 점수는 10,000 이하의 자연수
		}
		
		int[] dp = new int[stair];
		dp[0] = point[0];
		
		if(stair > 1) {
			dp[1] = point[0] + point[1];
		}
		
		if(stair > 2) {
			dp[2] = Math.max(point[0], point[1]) + point[2];
		}
		
		// 두가지 경우의 수가 있다
		// 1. 두칸 전에서 올라온 거  2. 세칸 전에서 한칸 전으로 그리고 올라온거
		for(int i = 3; i < stair; i++) {
			dp[i] = Math.max(dp[i-3] + point[i-1], dp[i-2]) + point[i];
		}
		
		// 계단 오르기 게임에서 얻을 수 있는 총 점수의 최댓값을 출력
		System.out.println(dp[stair-1]);
	}
}

//# input :
//6
//10
//20
//15
//25
//10
//20

//# output :
//75
