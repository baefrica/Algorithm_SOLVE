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
		
		// 오른쪽, 아래만 탐색하면 된다 !!
		int[] dr = { 0, 1 };
		int[] dc = { 1, 0 };
		
		int ans = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				for(int d = 0; d < 2; d++) {
					int nr = i + dr[d];
					int nc = j + dc[d];
					
					// 사방 탐색 중 경계값 넘어감
					if( nr >= N || nc >= N ) {
						continue;
					}
//					// 색이 같다면 넘어감
//					if(board[i][j] == board[nr][nc]) {
//						continue;
//					}
					// 사탕 교환
					swap( i, j, nr, nc );
					
					// 체크하기
					// 오른쪽 스왑을 했다면 i = nr, j != nc
					// i 행 체크, j 열, nc 열 체크
					if(d == 0) {
						ans = Math.max(ans, check0( i, j, nc ));
					}
					// 아래쪽 스왑을 했다면 i != nr, j = nc
					// j 열 체크, i 행, nr 행 체크
					else {
						ans = Math.max(ans, check1( j, i, nr ));
					}
					
					// 다시 교환
					swap( i, j, nr, nc );
				}	// 탐색 끝
			}
		}
		
		System.out.println(ans);
	}
}
