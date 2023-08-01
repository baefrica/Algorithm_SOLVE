import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node {
	int h, r, c;

	Node(int h, int r, int c) {
		this.h = h;
		this.r = r;
		this.c = c;
	}
}

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int M = sc.nextInt();
		int N = sc.nextInt();
		int H = sc.nextInt();

		int[][][] box = new int[H][N][M];
		Queue<Node> queue = new LinkedList<>();
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					box[i][j][k] = sc.nextInt();

					if (box[i][j][k] == 1) {
						queue.add(new Node(i, j, k));
					}
				}
			}
		}

		int[] dh = { 0, 0, 0, 0, -1, 1 };
		int[] dr = { 0, 0, -1, 1, 0, 0 };
		int[] dc = { -1, 1, 0, 0, 0, 0 };
		int cnt = -1;

		while (!queue.isEmpty()) {
			int size = queue.size();
			cnt++;

			for (int s = 0; s < size; s++) {
				Node curr = queue.poll();

				// 6방 탐색
				for (int d = 0; d < 6; d++) {
					int nh = curr.h + dh[d];
					int nr = curr.r + dr[d];
					int nc = curr.c + dc[d];

					if (nh < 0 || nr < 0 || nc < 0 || nh >= H || nr >= N || nc >= M) {
						continue;
					}

					if (box[nh][nr][nc] == 0) {
						queue.add(new Node(nh, nr, nc));
						box[nh][nr][nc] = 1;
					}
				}
			}
		} // while문 끝

		// 출력
		boolean flag = true;
		// 저장될 때부터 모든 토마토가 익어있는 상태
		if (cnt == 0) {
			System.out.println(0);
		} else {
			Loop: for (int i = 0; i < H; i++) {
				for (int j = 0; j < N; j++) {
					for (int k = 0; k < M; k++) {
						if (box[i][j][k] == 0) {
							flag = false;
							break Loop;
						}
					}
				}
			}

			if (flag) {
				System.out.println(cnt);
			}
			// 토마토가 모두 익지는 못하는 상황
			else {
				System.out.println(-1);
			}
		}
	}
}