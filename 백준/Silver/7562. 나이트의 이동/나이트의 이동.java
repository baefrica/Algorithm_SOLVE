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

		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int I = sc.nextInt();
			int[][] board = new int[I][I];

			int nowX = sc.nextInt();
			int nowY = sc.nextInt();

			int nextX = sc.nextInt();
			int nextY = sc.nextInt();

			Queue<Node> queue = new LinkedList<>();
			int cnt = 0;

			queue.add(new Node(nowY, nowX));
			board[nowY][nowX] = cnt;

			int[] dr = { -1, -2, -2, -1, 1, 2, 2, 1 };
			int[] dc = { -2, -1, 1, 2, -2, -1, 1, 2 };

			while (!queue.isEmpty()) {
				int size = queue.size();
				cnt++;

				for (int s = 0; s < size; s++) {
					Node curr = queue.poll();
					// 탈출 조건
					if (curr.r == nextY && curr.c == nextX) {
						queue.clear();
						System.out.println(board[curr.r][curr.c]);
						break;
					}

					for (int d = 0; d < 8; d++) {
						int nr = curr.r + dr[d];
						int nc = curr.c + dc[d];

						// 기저조건
						if (nr < 0 || nc < 0 || nr >= I || nc >= I) {
							continue;
						}
						if (board[nr][nc] > 0) {
							continue;
						}

						queue.add(new Node(nr, nc));
						board[nr][nc] = cnt;
					}
				}
			}

		}
	}
}
