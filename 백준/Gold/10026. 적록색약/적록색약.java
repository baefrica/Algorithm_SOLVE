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
		char[][] grid = new char[N][N];

		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < N; j++) {
				grid[i][j] = str.charAt(j);
			}
		}

		// 4방 탐색 도구
		int[] dr = { 0, 0, -1, 1 };
		int[] dc = { -1, 1, 0, 0 };

		Queue<Node> queue = new LinkedList<>();
		boolean[][] visited = new boolean[N][N];
		int norCnt = 0;

		// 적녹색약이 아닌 사람이 봤을 때
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					queue.add(new Node(i, j));
					visited[i][j] = true;
					norCnt++;

					while (!queue.isEmpty()) {
						Node curr = queue.poll();

						for (int d = 0; d < 4; d++) {
							int nr = curr.r + dr[d];
							int nc = curr.c + dc[d];

							if (nr < 0 || nc < 0 || nr >= N || nc >= N) {
								continue;
							}
							if (visited[nr][nc]) {
								continue;
							}

							if (grid[curr.r][curr.c] == grid[nr][nc]) {
								queue.add(new Node(nr, nc));
								visited[nr][nc] = true;
							}
						}
					}
				}
			}
		}

		// 적녹색약인 사람이 봤을 때
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (grid[i][j] == 'G') {
					grid[i][j] = 'R';
				}
			}
		}

		queue = new LinkedList<>();
		visited = new boolean[N][N];
		int cbCnt = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					queue.add(new Node(i, j));
					visited[i][j] = true;
					cbCnt++;

					while (!queue.isEmpty()) {
						Node curr = queue.poll();

						for (int d = 0; d < 4; d++) {
							int nr = curr.r + dr[d];
							int nc = curr.c + dc[d];

							if (nr < 0 || nc < 0 || nr >= N || nc >= N) {
								continue;
							}
							if (visited[nr][nc]) {
								continue;
							}

							if (grid[curr.r][curr.c] == grid[nr][nc]) {
								queue.add(new Node(nr, nc));
								visited[nr][nc] = true;
							}
						}
					}
				}
			}
		}

		// 출력
		System.out.print(norCnt + " " + cbCnt);
	}
}