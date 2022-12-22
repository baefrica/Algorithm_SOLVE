import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int M = sc.nextInt();
		int N = sc.nextInt();
		boolean[][] map = new boolean[M][N];
		// 방향을 나타냄 -> 시계방향으로
		// 0 : 우, 1 : 하, 2 : 좌, 3 : 상
		int[] dr = { 0, 1, 0, -1 };
		int[] dc = { 1, 0, -1, 0 };
		
		int r = 0;		// 현재 행
		int c = 0;		// 현재 열
		int d = 0;		// 현재 방향
		int cnt = 0;	// 꺾인 횟수
		for(int i = 0; i < (M * N - 1); i++) {
			map[r][c] = true;
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			// 방향 전환
			if(nr < 0 || nr >= M || nc < 0 || nc >= N || map[nr][nc]) {
				d++;
				cnt++;
				if(d > 3) {
					d = 0;
				}
			}	// 방향전환 끝
			
			r += dr[d];
			c += dc[d];
		}	// for 문 끝
		
		sb.append(cnt);
		System.out.println(sb);
	}
}
