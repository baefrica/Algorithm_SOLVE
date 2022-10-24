import java.util.Arrays;
import java.util.Scanner;

public class Main {
	// dfs 사용해보자
	// 상하좌우 4방 탐색하면서 이동
	// 방향에 따른 이동으로 블록들이 한 방향으로 빈 블록 없이, 0 없이 붙는다.
	// 이때 같은 수의 블록이 만나면 합쳐지면서 2배해주기
	// 이미 합쳐진 곳은 표시 해주기
	// 최대 5번 움직임
	// 똑같은 수가 세 개가 있는 경우에는 이동하려고 하는 쪽의 칸이 먼저 합쳐진다
	// 그 결과 가장 큰 블록의 값
	static int N;
	static int[][] board;
	static int[][] tmp;
	static int[][] changed;
	static int ans = Integer.MIN_VALUE;
	
	// getMax : 최댓값 찾는 함수
	public static int getMax(int[][] changed) {
		int maxBlock = Integer.MIN_VALUE;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				maxBlock = Math.max(maxBlock, changed[i][j]);
			}
		}
		
		return maxBlock;
	}	// getMax 끝
	
	// dfs
	public static void dfs(int[][] board, int cnt) {
		// 최대 5번까지 움직일 수 있어
		if(cnt == 5) {
			ans = Math.max(ans, getMax(changed));
			
			// 확인용 ㅎㅎ..
//			for(int i = 0; i < N; i++)
//				System.out.println(Arrays.toString(changed[i]));
//			System.out.println();
			
			return;
		}
		
		for(int d = 0; d < 4; d++) {
			changed = change(board, d);
			dfs(changed, cnt+1);
		}
	}	// dfs 끝
	
	// change : 맵을 변화시켜 주는 함수
	public static int[][] change(int[][] board, int d) {
		tmp = new int[N][N];
		
		switch(d) {
		// up : 위로 다 몰아 !
		case 0 :
			for(int j = 0; j < N; j++) {
				int baseBlock = -1;		// 같은 숫자가 오길 바라며.. 저장할 블럭
				int idx = 0;					// 기억할 인덱스 값
				for(int i = 0; i < N; i++) {
					// 0이면 넘어가
					if(board[i][j] == 0) {
						continue;
					}
					
					// 같은 숫자가 담에 오면 2배로 합쳐진다
					if(board[i][j] == baseBlock) {
						tmp[idx-1][j] = (board[i][j] * 2);
						baseBlock = -1;
					}
					// 그렇지 않다면..
					// tmp 에 저장
					// baseBlock 에도 저장
					else {
						tmp[idx][j] = board[i][j];
						baseBlock = board[i][j];
						idx++;
					}
				}
			}
			break;
			
		// down : 아래로 다 몰아 !
		case 1 :
			for(int j = 0; j < N; j++) {
				int baseBlock = -1;		// 같은 숫자가 오길 바라며.. 저장할 블럭
				int idx = (N - 1);					// 기억할 인덱스 값
				for(int i = (N - 1); i >= 0; i--) {
					// 0이면 넘어가
					if(board[i][j] == 0) {
						continue;
					}
					
					// 같은 숫자가 담에 오면 2배로 합쳐진다
					if(board[i][j] == baseBlock) {
						tmp[idx+1][j] = (board[i][j] * 2);
						baseBlock = -1;
					}
					// 그렇지 않다면..
					// tmp 에 저장
					// baseBlock 에도 저장
					else {
						tmp[idx][j] = board[i][j];
						baseBlock = board[i][j];
						idx--;
					}
				}
			}
			break;
			
		// left : 왼쪽으로 다 몰아 !
		case 2 :
			for(int i = 0; i < N; i++) {
				int baseBlock = -1;		// 같은 숫자가 오길 바라며.. 저장할 블럭
				int jdx = 0;					// 기억할 인덱스 값
				for(int j = 0; j < N; j++) {
					// 0이면 넘어가
					if(board[i][j] == 0) {
						continue;
					}
					
					// 같은 숫자가 담에 오면 2배로 합쳐진다
					if(board[i][j] == baseBlock) {
						tmp[i][jdx-1] = (board[i][j] * 2);
						baseBlock = -1;
					}
					// 그렇지 않다면..
					// tmp 에 저장
					// baseBlock 에도 저장
					else {
						tmp[i][jdx] = board[i][j];
						baseBlock = board[i][j];
						jdx++;
					}
				}
			}
			break;
			
		// right : 오른쪽으로 다 몰아 !
		case 3 :
			for(int i = 0; i < N; i++) {
				int baseBlock = -1;		// 같은 숫자가 오길 바라며.. 저장할 블럭
				int jdx = (N - 1);					// 기억할 인덱스 값
				for(int j = (N - 1); j >= 0; j--) {
					// 0이면 넘어가
					if(board[i][j] == 0) {
						continue;
					}
					
					// 같은 숫자가 담에 오면 2배로 합쳐진다
					if(board[i][j] == baseBlock) {
						tmp[i][jdx+1] = (board[i][j] * 2);
						baseBlock = -1;
					}
					// 그렇지 않다면..
					// tmp 에 저장
					// baseBlock 에도 저장
					else {
						tmp[i][jdx] = board[i][j];
						baseBlock = board[i][j];
						jdx--;
					}
				}
			}
			break;
		}
		
		return tmp;
	}	// change 끝
	
	// main
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();				// 보드의 크기
		board = new int[N][N];		// 초기 보드판
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				board[i][j] = sc.nextInt();
			}
		}	// 입력 끝
		
		// dfs 돌려
		dfs(board, 0);
		System.out.println(ans);
	}	// main 끝
}