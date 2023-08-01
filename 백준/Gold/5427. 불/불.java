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
	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { -1, 1, 0, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int w = sc.nextInt();
			int h = sc.nextInt();
			char[][] map = new char[h][w];

			Queue<Node> FIRE = new LinkedList<>();
			Queue<Node> SG = new LinkedList<>();
			boolean[][] visited = new boolean[h][w];
			boolean escape = false;
			int cnt = 0;

			for (int i = 0; i < h; i++) {
				String str = sc.next();

				for (int j = 0; j < w; j++) {
					map[i][j] = str.charAt(j);

					if (map[i][j] == '*') {
						FIRE.add(new Node(i, j));
					}
					if (map[i][j] == '@') {
						SG.add(new Node(i, j));
						visited[i][j] = true;
					}
				}
			}

			while (!SG.isEmpty()) {
				cnt++; // 1초 지남

				// 불의 확산
				int FIREsize = FIRE.size();

				for (int s = 0; s < FIREsize; s++) {
					Node curr = FIRE.poll();

					for (int d = 0; d < 4; d++) {
						int nr = curr.r + dr[d];
						int nc = curr.c + dc[d];

						// 기저조건
						if (nr < 0 || nc < 0 || nr >= h || nc >= w) {
							continue;
						}
						if (map[nr][nc] == '#' || map[nr][nc] == '*') { // 불일 때도 기저조건 처리해줘야한다. -> 메모리 초과 뜸
							continue;
						}

						FIRE.add(new Node(nr, nc));
						map[nr][nc] = '*';
					}
				} // 불의 확산 끝

				int SGsize = SG.size();

				for (int s = 0; s < SGsize; s++) {
					Node curr = SG.poll();

					// 탈출 조건
					if (curr.r == 0 || curr.c == 0 || curr.r == h - 1 || curr.c == w - 1) {
						SG.clear();
						escape = true; // 탈출 성공
						break;
					}

					for (int d = 0; d < 4; d++) {
						int nr = curr.r + dr[d];
						int nc = curr.c + dc[d];

						// 기저 조건
						if (nr < 0 || nc < 0 || nr >= h || nc >= w) {
							continue;
						}
						if (visited[nr][nc]) {
							continue;
						}

						if (map[nr][nc] == '.') {
							SG.add(new Node(nr, nc));
							visited[nr][nc] = true;
						}
					}
				} // 상근 이동 끝

			} // while문 끝

			if (escape) {
				System.out.println(cnt);
			} else {
				System.out.println("IMPOSSIBLE");
			}
		} // 테케 끝
	}
}
