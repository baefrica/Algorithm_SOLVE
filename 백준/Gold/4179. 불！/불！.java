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

		int R = sc.nextInt();
		int C = sc.nextInt();
		char[][] map = new char[R][C];

		Queue<Node> fire = new LinkedList<>();
		Queue<Node> jihoon = new LinkedList<>();
		boolean[][] visited = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			String str = sc.next();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);

				if (map[i][j] == 'F') {
					fire.add(new Node(i, j));
				}
				if (map[i][j] == 'J') {
					jihoon.add(new Node(i, j));
					visited[i][j] = true;
				}
			}
		}

		int cnt = 0;
		int[] dr = { 0, 0, -1, 1 };
		int[] dc = { -1, 1, 0, 0 };
		boolean isPossible = false;

		// 지훈이가 가장자리로 갈 때까지
		while (!jihoon.isEmpty()) {
			// 매분마다 불이 확산된다.
			int fireSize = fire.size();

			for (int fs = 0; fs < fireSize; fs++) {
				Node curr = fire.poll();

				for (int d = 0; d < 4; d++) {
					int nr = curr.r + dr[d];
					int nc = curr.c + dc[d];

					if (nr < 0 || nc < 0 || nr >= R || nc >= C) {
						continue;
					}

					// 불이 퍼진 지점을 큐에 삽입
					if (map[nr][nc] == '.') {
						fire.add(new Node(nr, nc));
						// 불 났다고 표시
						map[nr][nc] = 'F';
					}
				}
			} // 불 퍼지는 것 끝

			int size = jihoon.size();
			cnt++;

			for (int s = 0; s < size; s++) {
				Node curr = jihoon.poll();

				// 종료 조건
				if (curr.r == 0 || curr.r == R - 1 || curr.c == 0 || curr.c == C - 1) {
					isPossible = true;
					jihoon.clear();
					break;
				}

				for (int d = 0; d < 4; d++) {
					int nr = curr.r + dr[d];
					int nc = curr.c + dc[d];

					if (nr < 0 || nc < 0 || nr >= R || nc >= C) {
						continue;
					}
					if (visited[nr][nc]) {
						continue;
					}

					// 이동할 수 있는 지점을 큐에 삽입
					if (map[nr][nc] == '.') {
						jihoon.add(new Node(nr, nc));
						visited[nr][nc] = true;
						map[curr.r][curr.c] = '.';
					}
				}
			}
		}

		if (isPossible) {
			System.out.println(cnt);
		} else {
			System.out.println("IMPOSSIBLE");
		}
	}
}