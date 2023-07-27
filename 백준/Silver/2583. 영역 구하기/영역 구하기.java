import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
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

		int M = sc.nextInt();
		int N = sc.nextInt();
		int[][] board = new int[M][N];

		int K = sc.nextInt();
		for (int k = 0; k < K; k++) {
			int leftX = sc.nextInt();
			int leftY = sc.nextInt();

			int rightX = sc.nextInt();
			int rightY = sc.nextInt();

			// 판에 해당하는 사각형에 색칠하기
			for (int i = M - rightY; i < M - leftY; i++) {
				for (int j = leftX; j < rightX; j++) {
					board[i][j] = 1;
				}
			}
		}

		Queue<Node> queue = new LinkedList<>();
		int[] dr = { 0, 0, -1, 1 };
		int[] dc = { -1, 1, 0, 0 };
		List<Integer> size = new LinkedList<>();

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				// 영역이 시작될 수 있는 지점에서 cnt 선언
				int cnt = 0;

				// 0을 찾으면 큐에 삽입
				if (board[i][j] == 0) {
					queue.add(new Node(i, j));
					board[i][j] = -1; // 방문처리
					cnt++;

					while (!queue.isEmpty()) {
						Node curr = queue.poll();

						// 4방 탐색
						for (int d = 0; d < 4; d++) {
							int nr = curr.r + dr[d];
							int nc = curr.c + dc[d];

							// 기저 조건
							if (nr < 0 || nc < 0 || nr >= M || nc >= N) {
								continue;
							}
							if (board[nr][nc] == -1 || board[nr][nc] == 1) {
								continue;
							}

							queue.add(new Node(nr, nc));
							board[nr][nc] = -1; // 방문처리
							cnt++;
						}
					}
				} // 끝나면 하나의 영역 확정

				// 영역의 넓이가 있다면
				if (cnt > 0) {
					size.add(cnt);
				}
			}
		}

		// 출력
		System.out.println(size.size());
		Collections.sort(size); // 오름차순 정렬
		for (int i = 0; i < size.size(); i++) {
			System.out.print(size.get(i) + " ");
		}
	}
}