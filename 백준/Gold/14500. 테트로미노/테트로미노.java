import java.util.Scanner;

public class Main {
	// 19가지의 테트로미노 종류..
	static int[] shape1 = {1, 1, 1, 1};
	static int[][] shape2 = {{1}, {1}, {1}, {1}};
	
	static int[][] shape3 = { {1, 1}, {1, 1} };
	
	/*
	static int[][] shape4 = { {1, 0}, {1, 0}, {1, 1} };
	static int[][] shape5 = { {0, 1}, {0, 1}, {1, 1} };
	static int[][] shape6 = { {1, 1, 1}, {1, 0, 0} };
	static int[][] shape7 = { {1, 1, 1}, {0, 1, 1} };
	static int[][] shape8 = { {1, 1}, {0, 1}, {0, 1} };
	static int[][] shape9 = { {1, 1}, {1, 0}, {1, 0} };
	static int[][] shape10 = { {0, 0, 1}, {1, 1, 1} };
	static int[][] shape11 = { {1, 0, 0}, {1, 1, 1} };
	
	static int[][] shape12 = { {1, 0}, {1, 1}, {0, 1} };
	static int[][] shape13 = { {0, 1}, {1, 1}, {1, 0} };
	static int[][] shape14 = { {0, 1, 1}, {1, 1, 0} };
	static int[][] shape15 = { {1, 1, 0}, {0, 0, 1} };

	static int[][] shape16 = { {1, 1, 1}, {0, 1, 0} };
	static int[][] shape17 = { {0, 1, 0}, {1, 1, 1} };
	static int[][] shape18 = { {0, 1}, {1, 1}, {0, 1} };
	static int[][] shape19 = { {1, 0}, {1, 1}, {1, 0} };
	*/
	
	// 3 X 2 배열 (총 8종류)
	// shape4, shape5, shape8, shape9, shape12, shape13, shape18, shape19
	static int[][][] shape32 = { { {1, 0}, {1, 0}, {1, 1} },
											  { {0, 1}, {0, 1}, {1, 1} },
											  { {1, 1}, {0, 1}, {0, 1} },
											  { {1, 1}, {1, 0}, {1, 0} },
											  { {1, 0}, {1, 1}, {0, 1} },
											  { {0, 1}, {1, 1}, {1, 0} },
											  { {0, 1}, {1, 1}, {0, 1} },
											  { {1, 0}, {1, 1}, {1, 0} } };
	
	// 2 X 3 배열 (총 8종류)
	// shape6, shape7, shape10, shape11, shape14, shape15, shape16, shape17
	static int[][][] shape23 = { { {1, 1, 1}, {1, 0, 0} },
											  { {1, 1, 1}, {0, 0, 1} },
											  { {0, 0, 1}, {1, 1, 1} },
											  { {1, 0, 0}, {1, 1, 1} },
											  { {0, 1, 1}, {1, 1, 0} },
											  { {1, 1, 0}, {0, 1, 1} },
											  { {1, 1, 1}, {0, 1, 0} },
											  { {0, 1, 0}, {1, 1, 1} } };
	
	static int sum = 0;
	static int max = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();		// 세로 크기
		int M = sc.nextInt();		// 가로 크기
		
		// 종이 보드판을 입력받는다
		int[][] board = new int[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		
		// 각각의 테트로미노 종류를 하나씩 보드판 위에 올려서
		// 그 자리에 해당하는 값과 곱한 다음 다 더하면 그만큼이 합이다.
		// (모양은 전체 직사각형 중 폴리오미노가 있는 칸이 1, 없는 칸이 0)
		/*
			따라서,,,
			곱하면 1인 자리는 보드판의 값을 그대로 가져오고
			곱하면 0인 자리는 안 가져올 수 있다 !!
		 */
		// 그 중 최댓값을 고를 것이다.
		
		// shape1
		for(int i = 0; i < N; i++) {
			for(int j = 0; j <= (M - 4); j++) {
				sum = 0;
				sum = (board[i][j] * shape1[0]) + (board[i][j+1] * shape1[1]) + (board[i][j+2] * shape1[2]) + (board[i][j+3] * shape1[3]);
				max = Math.max(max, sum);
			}
		}
		
		// shape2
		for(int i = 0; i <= (N - 4); i++) {
			for(int j = 0; j < M; j++) {
				sum = 0;
				sum = (board[i][j] * shape2[0][0]) + (board[i+1][j] * shape2[1][0]) + (board[i+2][j] * shape2[2][0]) + (board[i+3][j] * shape2[3][0]);
				max = Math.max(max, sum);
			}
		}
		
		// shape3
		for(int i = 0; i <= (N - 2); i++) {
			for(int j = 0; j <= (M - 2); j++) {
				sum = 0;
				sum = (board[i][j] * shape3[0][0]) + (board[i][j+1] * shape3[0][1]) + (board[i+1][j] * shape3[1][0]) + (board[i+1][j+1] * shape3[1][1]);
				max = Math.max(max, sum);
			}
		}
		
		// 3 X 2 배열 묶자 !!
		// shape4, shape5, shape8, shape9, shape12, shape13, shape18, shape19
		for(int n = 0; n < 8; n++) {
			for(int i = 0; i <= (N - 3); i++) {
				for(int j = 0; j <= (M - 2); j++) {
					sum = 0;
					sum = (board[i][j] * shape32[n][0][0]) + (board[i][j+1] * shape32[n][0][1]) 
							+ (board[i+1][j] * shape32[n][1][0]) + (board[i+1][j+1] * shape32[n][1][1])
							+ (board[i+2][j] * shape32[n][2][0]) + (board[i+2][j+1] * shape32[n][2][1]);
					max = Math.max(max, sum);
				}
			}
		}
		
		// 2 X 3 배열 (총 8종류) 묶자 !!
		// shape6, shape7, shape10, shape11, shape14, shape15, shape16, shape17
		for(int n = 0; n < 8; n++) {
			for(int i = 0; i <= (N - 2); i++) {
				for(int j = 0; j <= (M - 3); j++) {
					sum = 0;
					sum = (board[i][j] * shape23[n][0][0]) + (board[i][j+1] * shape23[n][0][1]) + (board[i][j+2] * shape23[n][0][2])
							+ (board[i+1][j] * shape23[n][1][0]) 	+ (board[i+1][j+1] * shape23[n][1][1]) + (board[i+1][j+2] * shape23[n][1][2]);
					max = Math.max(max, sum);
				}
			}
		}
		
		// 최종적으로 최댓값 출력
		System.out.println(max);
	}
}
