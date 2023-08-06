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
		int M = sc.nextInt();
		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		Queue<Node> queue = new LinkedList<>();
		boolean[][] visited;
		boolean[][] flag; // 빙산이 녹을 때 0이 된 것을 체크해주기 위해 (동시에 녹는 것 방지)
		int[] dr = { 0, 0, -1, 1 };
		int[] dc = { -1, 1, 0, 0 };

		int year = 0;
		Loop1: while (true) {
			// 빙산 분리된 덩어리 갯수 세기
			int cnt = 0;
			visited = new boolean[N][M];
			for (int i = 1; i < N - 1; i++) {
				for (int j = 1; j < M - 1; j++) {
					// 방문하지 않은 빙산 찾았다.
					if (!visited[i][j] && map[i][j] > 0) {
						queue.add(new Node(i, j));
						visited[i][j] = true;
						cnt++;
						// 두 덩어리 이상으로 분리되었다.
						if (cnt > 1) {
							System.out.println(year); // 최초의 시간(년) 출력
							break Loop1;
						}

						while (!queue.isEmpty()) {
							Node curr = queue.poll();

							for (int d = 0; d < 4; d++) {
								int nr = curr.r + dr[d];
								int nc = curr.c + dc[d];

								if (!visited[nr][nc] && map[nr][nc] > 0) {
									queue.add(new Node(nr, nc));
									visited[nr][nc] = true;
								}
							}
						}
					}
				}
			} // 빙산 덩어리 갯수 세기 끝

			// 빙산이 다 녹을 때까지 분리되지 않으면 0을 출력
			if (cnt == 0) {
				System.out.println(0);
				break;
			}

			year++; // +1년 후

			// 빙산 녹이기
			flag = new boolean[N][M];
			for (int i = 1; i < N - 1; i++) {
				for (int j = 1; j < M - 1; j++) {
					// 빙산을 찾았다.
					if (map[i][j] > 0) {
						// 4방 탐색
						for (int d = 0; d < 4; d++) {
							int nr = i + dr[d];
							int nc = j + dc[d];

							// 바다가 있다면 빙산의 높이 -1 녹이자
							if (!flag[nr][nc] && map[nr][nc] == 0) {
								map[i][j]--;

								// 다 녹았다. -> 4방 탐색 그만해도 됨
								if (map[i][j] == 0) {
									flag[i][j] = true; // 동시에 녹는 것을 방지하기 위해
									break;
								}
							}
						}
					}
				}
			} // 전체 빙산 녹이기 1회 끝
		} // Loop1 끝
	}
}
