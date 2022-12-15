import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		sc.nextLine();
		int num = 1;
		char[][] board = new char[N][M];
		for(int i = 0; i < N; i++) {
			String BW = sc.nextLine();
			
			for(int j = 0; j < M; j++) {
				board[i][j] = BW.charAt(j);
			}
		}	// 입력 끝
		
		int ans = Integer.MAX_VALUE;
		// 8 X 8 체스판 경우의 수
		for(int n = 0; n < (N - 7); n++) {
			for(int m = 0; m < (M - 7); m++) {
				int cntB = 0;			// 1번 경우의 수 카운팅
				int cntW = 0;			// 2번 경우의 수 카운팅
				int cnt = 0;			// 둘 중 최솟값 저장
				// 행, 열 상태를 바꿔준다 계속
				// 짝수행, 짝수열 : false
				// 홀수행, 홀수열 : true
				boolean rowFlag = false;
				boolean colFlag = false;
				
				// 두가지 경우의 수를 생각 : BWBW... , WBWB...
				for(int i = n; i < (n + 8); i++) {
					for(int j = m; j < (m + 8); j++) {
						
						// 1. 시작점을 B 라고 한다면
						if(!rowFlag && !colFlag) {
							if(board[i][j] != 'B') {
								cntB++;
							}
						}
						else if(!rowFlag && colFlag) {
							if(board[i][j] != 'W') {
								cntB++;
							}
						}
						else if(rowFlag && !colFlag) {
							if(board[i][j] != 'W') {
								cntB++;
							}
						}
						else {
							if(board[i][j] != 'B') {
								cntB++;
							}
						}
						
						// 2. 시작점을 W 라고 한다면
						if(!rowFlag && !colFlag) {
							if(board[i][j] != 'W') {
								cntW++;
							}
						}
						else if(!rowFlag && colFlag) {
							if(board[i][j] != 'B') {
								cntW++;
							}
						}
						else if(rowFlag && !colFlag) {
							if(board[i][j] != 'B') {
								cntW++;
							}
						}
						else {
							if(board[i][j] != 'W') {
								cntW++;
							}
						}
						// 두 카운팅 중 최솟값으로 갱신
						cnt = Math.min(cntB, cntW);
						// 컬럼 상태 변경
						colFlag = !colFlag;
					}
					// 로우 상태 변경
					rowFlag = !rowFlag;
				}	// 한 체스판 경우의 수 검사 끝
				ans = Math.min(ans, cnt);		// 한 체스판 경우의 수 검사 후 최솟값으로 갱신
			}
		}
		System.out.println(ans);
	}
}