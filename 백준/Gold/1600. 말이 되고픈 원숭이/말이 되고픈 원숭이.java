import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node {
	int r, c, cntK, moveCnt;

	Node(int r, int c, int cntK, int moveCnt) {
		this.r = r;
		this.c = c;
		this.cntK = cntK;
		this.moveCnt = moveCnt;
	}
}

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int K = sc.nextInt();
		int W = sc.nextInt();
		int H = sc.nextInt();
		int[][] board = new int[H][W];
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				board[i][j] = sc.nextInt();
			}
		}

		Queue<Node> queue = new LinkedList<>();
		// visited 배열을 말의이동을 몇번 했는 지에 따라 다르게 두어야한다!!
		boolean[][][] visited = new boolean[H][W][K + 1];
		int[] dr = { 0, 0, -1, 1, -1, -2, -2, -1, 1, 2, 2, 1 };
		int[] dc = { -1, 1, 0, 0, -2, -1, 1, 2, -2, -1, 1, 2 };
		boolean flag = false;

		queue.add(new Node(0, 0, 0, 0));
		visited[0][0][0] = true;

		while (!queue.isEmpty()) {
			Node curr = queue.poll();

			// 종료 조건
			if (curr.r == H - 1 && curr.c == W - 1) {
				System.out.println(curr.moveCnt);
				flag = true;
				break;
			}

			int nr, nc;
			// 4방 탐색
			for (int d = 0; d < 4; d++) {
				nr = curr.r + dr[d];
				nc = curr.c + dc[d];

				if (nr < 0 || nc < 0 || nr >= H || nc >= W) {
					continue;
				}
				if (visited[nr][nc][curr.cntK]) {
					continue;
				}

				if (board[nr][nc] == 0) {
					queue.add(new Node(nr, nc, curr.cntK, curr.moveCnt + 1));
					visited[nr][nc][curr.cntK] = true;
				}
			}
			// 말처럼 이동할 횟수가 남아있다면
			if (curr.cntK < K) {
				for (int d = 4; d < 12; d++) {
					nr = curr.r + dr[d];
					nc = curr.c + dc[d];

					if (nr < 0 || nc < 0 || nr >= H || nc >= W) {
						continue;
					}
					if (visited[nr][nc][curr.cntK+1]) {	// "말처럼 이동횟수+1" 에 해당하는 visited 배열을 살펴봐야한다!!
						continue;
					}

					if (board[nr][nc] == 0) {
						queue.add(new Node(nr, nc, curr.cntK + 1, curr.moveCnt + 1));
						visited[nr][nc][curr.cntK + 1] = true;
					}
				}
			}
		} // while문 끝

		if (!flag) {
			System.out.println(-1);
		}
	}
}
