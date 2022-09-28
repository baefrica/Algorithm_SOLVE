import java.util.Scanner;

public class Solution {
	static int N;
	static int K;
	static int[][] map;
	static int ans;
	
	static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
	
    // dfs
	public static void DFS(int r, int c, int leng, boolean isBreak) {
		// 4방 탐색해서
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			// 패스 조건
			if(nr < 0 || nc < 0 || nr >= N || nc >= N) {
				continue;
			}
			if(visited[nr][nc] == true) {
				continue;
			}
			
			// 등산로 높이가 나보다 같거나 클 때
			// 한번은 뿌술 수 있다 (최대 K 만큼)
			if(map[nr][nc] >= map[r][c]) {
				// 부신 적이 없다면
				if(isBreak == false) {
					// 깎아보자. 최대 K만큼
					for(int k = 1; k <= K; k++) {
						// 깎아서 나보다 작아진다면
						if((map[nr][nc] - k) < map[r][c]) {
							// 깎자 !
							map[nr][nc] -= k;
							DFS(nr, nc, leng+1, true);
							// 원상복귀
							map[nr][nc] += k;
						}
					}
				}
			}
			// 나보다 낮으면 무조건 간다
			else {
				// 방문처리 한다
				visited[nr][nc] = true;
				DFS(nr, nc, leng+1, isBreak);
				// 원상복귀
				visited[nr][nc] = false;
			}
		}
		// dfs 쭈욱 한번 끝까지 갔으면
		ans = Math.max(ans, leng);
	}
	
	// main
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			N = sc.nextInt();	// 지도 크기
			K = sc.nextInt();	// 공사 최대 깊이
			map = new int[N][N];
			int heightMax = Integer.MIN_VALUE;  // 최대 높이가 몇인지 찾을 것
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
					heightMax = Math.max(heightMax,  map[i][j]);
				}
			}
			// 방문처리 배열
			visited = new boolean[N][N];
			// 최대 길이
			ans = Integer.MIN_VALUE;
			
			// 시작할 지점 찾아서 DFS 돌리기
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					// 최대 높이에 해당하는 지점을 발견 !
					if(heightMax == map[i][j]) {
						// 일단 시작 지점부터 방문 처리 !
						visited[i][j] = true;
						DFS(i, j, 1, false);
						// 원상 복귀
						visited[i][j] = false;
					}
				}
			}
			//
			System.out.println("#" + t + " " + ans);
		}	// 테케 끝
	}
}