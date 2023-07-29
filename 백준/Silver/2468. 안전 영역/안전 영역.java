import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node {
	int r, c;

	Node(int r, int c) {
		this.r = r;
		this.c = c;
	}
}

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[][] board = new int[N][N];

		int max = 1;
		int min = 100;
		int ans = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				board[i][j] = sc.nextInt();

				max = Math.max(max, board[i][j]);
				min = Math.min(min, board[i][j]);
			}
		}

		Queue<Node> queue = new LinkedList<>();
		int[] dr = { 0, 0, -1, 1 };
		int[] dc = { -1, 1, 0, 0 };

		// 틀린이유 : (최솟값 - 1) 부터 (최댓값 + 1) 까지
		for (int h = min - 1; h <= max + 1; h++) {
			boolean[][] visited = new boolean[N][N];
			int cnt = 0; // 안전영역 갯수

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					// 방문하지 않았고 안 잠긴 시작점 찾으면
					if (board[i][j] > h && !visited[i][j]) {
						cnt++;
						queue.add(new Node(i, j));
						visited[i][j] = true;

						while (!queue.isEmpty()) {
							Node curr = queue.poll();

							// 4방 탐색
							for (int d = 0; d < 4; d++) {
								int nr = curr.r + dr[d];
								int nc = curr.c + dc[d];

								// 기저조건
								if (nr < 0 || nc < 0 || nr >= N || nc >= N) {
									continue;
								}
								if (visited[nr][nc]) {
									continue;
								}
								if (board[nr][nc] <= h) {
									continue;
								}

								queue.add(new Node(nr, nc));
								visited[nr][nc] = true;
							} // 4방 탐색 끝
						} // while문 끝
					}
				}
			} // 2차원배열 탐색 끝

			ans = Math.max(ans, cnt);
		}

		// 물에 잠기지 않는 안전한 영역의 최대 개수를 출력
		System.out.println(ans);
	}
}