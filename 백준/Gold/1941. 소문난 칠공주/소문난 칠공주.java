import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Node {
	int r, c;

	Node(int r, int c) {
		this.r = r;
		this.c = c;
	}
}

public class Main {
	static char[][] board;
	static boolean[][] visited;
	static Node[] result;
	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { -1, 1, 0, 0 };
	static boolean[] resVisited;
	static int answer;

	public static boolean bfs(Node[] res) {
		int CNT = 0;
		int S_CNT = 0;
		int Y_CNT = 0;

		Queue<Node> queue = new LinkedList<>();
		resVisited = new boolean[7];

		queue.add(result[0]);
		resVisited[0] = true;

		// 갯수 체크
		if (board[result[0].r][result[0].c] == 'S') {
			S_CNT++;
		} else {
			Y_CNT++;
		}
		CNT = S_CNT + Y_CNT;

		while (!queue.isEmpty()) {
			Node curr = queue.poll();

			// bfs를 돌리면서 모두가 연결되어 있는지 확인하기
			// bfs 돌릴 때 주의할 점 : 연결되어 있는 것들 다 큐에 집어넣기 -> 즉 큐에 집어넣고 빠져나오면 안된다!!
			for (int d = 0; d < 4; d++) {
				int nr = curr.r + dr[d];
				int nc = curr.c + dc[d];

				// 경계 조건
				if (nr < 0 || nc < 0 || nr >= 5 || nc >= 5) {
					continue;
				}

				// 정답지 중 연결된게 있는 지 하나씩 확인
				for (int i = 0; i < 7; i++) {
					if (resVisited[i]) {
						continue;
					}

					// 연결이 되어있다.
					if (nr == result[i].r && nc == result[i].c) {
						queue.add(new Node(nr, nc)); // 큐에 삽입
						resVisited[i] = true; // 방문 표시

						// 갯수 체크
						if (board[nr][nc] == 'S') {
							S_CNT++;
						} else {
							Y_CNT++;
						}
						CNT = S_CNT + Y_CNT;
					}
				}
			}
		}

		if (CNT == 7 && S_CNT >= 4) {
			return true;
		} else {
			return false;
		}
	}

	public static void dfs(int idx, int cnt) {
		// 기저조건 : 7명이 완성된다면
		if (cnt == 7) {
			// bfs도 통과했다면
			if (bfs(result)) {
				answer++;
			}

			return;
		}

		// 7명을 뽑는 과정
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (visited[i][j]) {
					continue;
				}

				// 행이 작다면
				if (idx > 0 && result[idx - 1].r > i) {
					continue;
				}
				// 같은 행일 때, 열이 작거나 같으면
				if (idx > 0 && result[idx - 1].r == i && result[idx - 1].c >= j) {
					continue;
				}

				result[idx] = new Node(i, j);
				visited[i][j] = true;
				dfs(idx + 1, cnt + 1);
				visited[i][j] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		board = new char[5][5];
		for (int i = 0; i < 5; i++) {
			String str = br.readLine();
			for (int j = 0; j < 5; j++) {
				board[i][j] = str.charAt(j);
			}
		}

		visited = new boolean[5][5];
		result = new Node[7];

		dfs(0, 0);

		// 출력
		System.out.println(answer);
	}
}
