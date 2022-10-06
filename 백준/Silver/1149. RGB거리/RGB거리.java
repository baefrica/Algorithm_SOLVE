import java.util.Scanner;

public class Main {
	public static void dp (int color) {
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[][] dp = new int[N][3];
		dp[0][0] = sc.nextInt();
		dp[0][1] = sc.nextInt();
		dp[0][2] = sc.nextInt();
		
		// 이전에 선택한 색깔은 선택 X
		for(int i = 1; i < N; i++) {
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + sc.nextInt();
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + sc.nextInt();
			dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + sc.nextInt();
		}
		
		System.out.println(Math.min(Math.min(dp[N-1][0], dp[N-1][1]), dp[N-1][2]));
	}
}

//# input :
//3
//26 40 83
//49 60 57
//13 89 99

//3
//1 100 100
//100 1 100
//100 100 1

//3
//1 100 100
//100 100 100
//1 100 100

//6
//30 19 5
//64 77 64
//15 19 97
//4 71 57
//90 86 84
//93 32 91

//8
//71 39 44
//32 83 55
//51 37 63
//89 29 100
//83 58 11
//65 13 15
//47 25 29
//60 66 19

//# output :
//96
//
//3
//
//102
//
//208
//
//253
