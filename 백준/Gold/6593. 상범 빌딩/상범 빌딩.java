import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
	int h, r, c, cnt;

	Node(int h, int r, int c, int cnt) {
		this.h = h;
		this.r = r;
		this.c = c;
		this.cnt = cnt;
	}
}

public class Main {
	static int[] dh = { 0, 0, 0, 0, -1, 1 };
	static int[] dr = { 0, 0, -1, 1, 0, 0 };
	static int[] dc = { -1, 1, 0, 0, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());

			// while문 종료
			if (L == 0) {
				break;
			}

			char[][][] building = new char[L][R][C];
			Queue<Node> queue = new LinkedList<>();
			boolean[][][] visited = new boolean[L][R][C];
			boolean isEscape = false;

			// 입력 받기
			for (int i = 0; i < L; i++) {
				for (int j = 0; j < R; j++) {
					String str = br.readLine();

					for (int k = 0; k < C; k++) {
						building[i][j][k] = str.charAt(k);

						// 시작 지점
						if (building[i][j][k] == 'S') {
							queue.add(new Node(i, j, k, 0));
							visited[i][j][k] = true;
						}
					}
				}

				String tmp = br.readLine();
			}

			// BFS
			while (!queue.isEmpty()) {
				Node curr = queue.poll();

				// 탈출 출구
				if (building[curr.h][curr.r][curr.c] == 'E') {
					System.out.println("Escaped in " + curr.cnt + " minute(s)."); // 탈출 메세지
					queue.clear(); // 큐 비우기
					isEscape = true; // 탈출 성공 표시
					break;
				}

				// 6방 탐색
				for (int d = 0; d < 6; d++) {
					int nh = curr.h + dh[d];
					int nr = curr.r + dr[d];
					int nc = curr.c + dc[d];

					// 기저 조건
					if (nh < 0 || nr < 0 || nc < 0 || nh >= L || nr >= R || nc >= C) { // 경계 검사
						continue;
					}
					if (visited[nh][nr][nc]) { // 방문 검사
						continue;
					}
					if (building[nh][nr][nc] == '#') { // 벽일 때
						continue;
					}

					queue.add(new Node(nh, nr, nc, curr.cnt + 1));
					visited[nh][nr][nc] = true;
				}
			} // BFS 끝

			if (!isEscape) {
				System.out.println("Trapped!");
			}
		} // 전체 while문 끝
	}
}