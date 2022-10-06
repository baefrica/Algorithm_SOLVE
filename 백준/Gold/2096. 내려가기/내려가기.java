import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		// 메모리 초과 방지를 위해..입력받으면서 처리ㅠ
		int[][] dp1 = new int[2][3];
		int[][] dp2 = new int[2][3];
		dp1[0][0] = dp2[0][0] = sc.nextInt();
		dp1[0][1] = dp2[0][1] = sc.nextInt();
		dp1[0][2] = dp2[0][2] = sc.nextInt();
		
		// 이전에 선택한 숫자 바로 아래와 붙어있는 수만 갈 수 있다
		// 입력받으면서 처리..ㅠ
		for (int i = 1; i < N; i++) {
			int a = sc.nextInt();
			// 두 줄 비교해서 최적해 찾는다
			dp1[1][0] = Math.max(dp1[0][0], dp1[0][1]) + a;
			dp2[1][0] = Math.min(dp2[0][0], dp2[0][1]) + a;
			
			int b = sc.nextInt();
			dp1[1][1] = Math.max(Math.max(dp1[0][0], dp1[0][1]), dp1[0][2]) + b;
			dp2[1][1] = Math.min(Math.min(dp2[0][0], dp2[0][1]), dp2[0][2]) + b;
			
			int c = sc.nextInt();
			dp1[1][2] = Math.max(dp1[0][1], dp1[0][2]) + c;
			dp2[1][2] = Math.min(dp2[0][1], dp2[0][2]) + c;
			
			// 다음으로 넘어가기 전에 이번 최적해로 갱신
			dp1[0][0] = dp1[1][0];
			dp2[0][0] = dp2[1][0];
			
			dp1[0][1] = dp1[1][1];
			dp2[0][1] = dp2[1][1];
			
			dp1[0][2] = dp1[1][2];
			dp2[0][2] = dp2[1][2];
		}
		
		int max = Math.max(Math.max(dp1[0][0], dp1[0][1]), dp1[0][2]);
		int min = Math.min(Math.min(dp2[0][0], dp2[0][1]), dp2[0][2]);
		
		System.out.println(max + " " + min);
	}
}

//# input :
//3
//1 2 3
//4 5 6
//4 9 0

//3
//0 0 0
//0 0 0
//0 0 0

//# output :
//18 6
//
//0 0
