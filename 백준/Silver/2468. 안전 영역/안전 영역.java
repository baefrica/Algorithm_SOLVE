import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N;
	static int[][] area;
	static int max = Integer.MIN_VALUE;	// 높이 중 최댓값
	static int min = Integer.MAX_VALUE;	// 높이 중 최솟값
	static int[] safezoneCnt;	// 안전영역 갯수 저장할 배열
	static int ans;
	static int maxAns = Integer.MIN_VALUE;		// 안전한 영역의 최대 갯수
	static int k = 0;
	static int h;
	
	// 4방탐색 (상 우 하 좌)
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void dfs(int r, int c) {
		// 비의 양으로 높이를 바꿔준다 !!
		area[r][c] = h;
		
		// 4방탐색
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			// 넘기는 조건들
			if(nr < 0 || nc < 0 || nr >= N || nc >= N) {
                continue;
            }
			if(area[nr][nc] <= h) {
                continue;
            }
			
			dfs(nr, nc);
		}	//탐색
	}
	
	// main
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		area = new int[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				area[i][j] = sc.nextInt();
				max = Math.max(max, area[i][j]);
				min = Math.min(min, area[i][j]) - 1;
			}
		}
		
		// 비의 양에 따른 모든 경우
		safezoneCnt = new int[max-min+1];
		
		// 큰 비의 양부터 내려간다
		for(h = max; h >= min; h--) {
			ans = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(area[i][j] > h) {
						ans++;
						dfs(i, j);
					}
				}
			}
			safezoneCnt[k] = ans;
			k++;
		}
		
		for(int i = 0; i < safezoneCnt.length; i++) {
			maxAns = Math.max(maxAns, safezoneCnt[i]);
		}
		
		System.out.println(maxAns);
	}
}