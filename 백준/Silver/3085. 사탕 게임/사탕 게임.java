import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int N;
	static char[][] board;
	
	// swap
	public static void swap(int aIdx, int aJdx, int bIdx, int bJdx) {
		char tmp = board[aIdx][aJdx];
		board[aIdx][aJdx] = board[bIdx][bJdx];
		board[bIdx][bJdx] = tmp;
	}
	
	// check0
	public static int check0(int i, int j, int nc) {
		int maxCnt = 0;
		
		int cnt = 1;
		for(int y = 0; y < (N - 1); y++) {
			if(board[i][y] == board[i][y+1]) {
				cnt++;
			}
			else {
				cnt = 1;
			}
			maxCnt = Math.max(cnt, maxCnt);
		}
		
		cnt = 1;
		for(int x = 0; x < (N - 1); x++) {
			if(board[x][j] == board[x+1][j]) {
				cnt++;
			}
			else {
				cnt = 1;
			}
			maxCnt = Math.max(cnt, maxCnt);
		}
		
		cnt = 1;
		for(int x = 0; x < (N - 1); x++) {
			if(board[x][nc] == board[x+1][nc]) {
				cnt++;
			}
			else {
				cnt = 1;
			}
			maxCnt = Math.max(cnt, maxCnt);
		}
		
		return maxCnt;
	}
	
	// check1
	public static int check1(int j, int i, int nr) {
		int maxCnt = 0;
		
		int cnt = 1;
		for(int x = 0; x < (N - 1); x++) {
			if(board[x][j] == board[x+1][j]) {
				cnt++;
			}
			else {
				cnt = 1;
			}
			maxCnt = Math.max(cnt, maxCnt);
		}
		
		cnt = 1;
		for(int y = 0; y < (N - 1); y++) {
			if(board[i][y] == board[i][y+1]) {
				cnt++;
			}
			else {
				cnt = 1;
			}
			maxCnt = Math.max(cnt, maxCnt);
		}
		
		cnt = 1;
		for(int y = 0; y < (N - 1); y++) {
			if(board[nr][y] == board[nr][y+1]) {
				cnt++;
			}
			else {
				cnt = 1;
			}
			maxCnt = Math.max(cnt, maxCnt);
		}
		
		return maxCnt;
	}
	
	// main
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());

		board = new char[N][N];
		for(int i = 0; i < N; i++) {
			String candy = br.readLine();
			for(int j = 0; j < N; j++) {
				board[i][j] = candy.charAt(j);
			}
		}
		
//		for(int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(board[i]));
//		}
		
		// ?????????, ????????? ???????????? ?????? !!
		int[] dr = { 0, 1 };
		int[] dc = { 1, 0 };
		
		int ans = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				for(int d = 0; d < 2; d++) {
					int nr = i + dr[d];
					int nc = j + dc[d];
					
					// ?????? ?????? ??? ????????? ?????????
					if( nr >= N || nc >= N ) {
						continue;
					}
//					// ?????? ????????? ?????????
//					if(board[i][j] == board[nr][nc]) {
//						continue;
//					}
					// ?????? ??????
					swap( i, j, nr, nc );
					
					// ????????????
					// ????????? ????????? ????????? i = nr, j != nc
					// i ??? ??????, j ???, nc ??? ??????
					if(d == 0) {
						ans = Math.max(ans, check0( i, j, nc ));
					}
					// ????????? ????????? ????????? i != nr, j = nc
					// j ??? ??????, i ???, nr ??? ??????
					else {
						ans = Math.max(ans, check1( j, i, nr ));
					}
					
					// ?????? ??????
					swap( i, j, nr, nc );
				}	// ?????? ???
			}
		}
		
		System.out.println(ans);
	}
}
