import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			// 저수지 깊이 입력받는다
			int N = sc.nextInt();
			char[][] arr = new char[N][N];
			
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < N; c++) {
					arr[r][c] = sc.next().charAt(0);
				}
			}
			
			int[] dr = {-1, -1, -1, 0, 1, 1, 1, 0};
			int[] dc = {-1, 0, 1, 1, 1, 0, -1, -1};
			int nr, nc;
			// 주변이 모두 땅이면 1
			int max = 1;
			
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < N; c++) {
					int cnt = 0;
					
					// 입력받은 배열 중 W를 찾는다
					if(arr[r][c] == 'W') {
						for(int d = 0; d < 8; d++) {
							nr = r + dr[d];
							nc = c + dc[d];
							
							// 경계 넘어갈 때
							if(nr == -1 || nr == N || nc == -1 || nc == N) {
								break;
							}
							
							// 델타로 주변 탐색하는 데 W가 있으면 카운팅
							if(arr[nr][nc] == 'W') {
								cnt++;
							}
						}
						
						// 카운팅 중 최댓값을 찾는다
						if(max < cnt) {
							max = cnt;
						}
					}
				}
			}
			System.out.println("#" + tc + " " + max);			
		}
	}
}