import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int M;
	static int N;
	static int[][] box;
	static int cnt;
	static Queue<Node> queue = new LinkedList<>();

	// 시계방향으로 4방 탐색 (상 우 하 좌)
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static class Node {
		int r, c;

		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	// main // bfs
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();	// 가로
		M = sc.nextInt();	// 세로
		box = new int[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				box[i][j] = sc.nextInt();
			}
		}
		
		int zeroCnt = 0;
		// 익은 걸 찾으면 큐에 다 넣는다
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if(box[i][j] == 1) {
					queue.add(new Node(i, j));
				}
				// 처음부터 다 익었는지 보기위함
				if(box[i][j] == 0) {
					zeroCnt++;
				}
			}
		}

		cnt = -1;
//		Loop :
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int t = 0; t < size; t++) {
				Node n = queue.poll();

				// 4방탐색
				for (int d = 0; d < 4; d++) {
					int nr = n.r + dr[d];
					int nc = n.c + dc[d];
					// 패스 조건
					if (nr < 0 || nc < 0 || nr >= M || nc >= N) {
						continue;
					}
					if (box[nr][nc] == -1 || box[nr][nc] == 1) {
						continue;
					}
					// 패스 조건 끝
					box[nr][nc] = 1;
					queue.add(new Node(nr, nc));
				} // 4방탐색 for 문 끝
			}
			// for 문 돌고 하루 지남
			cnt++;
			
//			int exitCnt = 0;
//			for (int i = 0; i < M; i++) {
//				for (int j = 0; j < N; j++) {
//					if(box[i][j] == 0) {
//						break Loop;
//					}
//				}
//			}
			
//			if(exitCnt == 0) {
//				flag = false;
//			}
			
		} // while 문 끝
		
		// 다 끝나고 안익은게 있나.. 체크
		int noCnt = 0;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (box[i][j] == 0) {
					noCnt++;
				}
			}
		}
		
		// 출력
		// 처음부터 안익은게 없으면
		if(zeroCnt == 0) {
			System.out.println(0);
		}
		else {
			// 다 돌고 안익은게 남아있다면
			if(noCnt > 0) {
				System.out.println(-1);
			}
			// 다 돌고 다 익었다면
			else {
				System.out.println(cnt);
			}
		}
	} // main
} // main class