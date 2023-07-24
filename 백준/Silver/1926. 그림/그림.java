import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node {
	int r;
	int c;

	Node(int r, int c) {
		this.r = r;
		this.c = c;
	}
}

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(); // 세로 길이
		int m = sc.nextInt(); // 가로 길이
		int[][] board = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				board[i][j] = sc.nextInt();
			}
		}

		// 큐와 visited 배열은 다음 그림에 영향을 끼치지 않는다!!
		Queue<Node> queue = new LinkedList<>(); // 큐 생성
		boolean[][] visited = new boolean[n][m]; // 방문 처리 배열 생성
		int cnt = 0; // 그림의 갯수
		int maxSize = 0; // 가장 넓은 그림의 넓이

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				// 방문하지 않은 1을 발견했다.
				if (board[i][j] == 1 && !visited[i][j]) {
					int size = 0; // 그림의 넓이
					cnt++; // 그림 갯수 + 1

					// 그림의 시작점에 대한 작업들
					queue.add(new Node(i, j)); // 큐에 삽입
					visited[i][j] = true; // 방문 처리
					size++; // 그림의 넓이 + 1

					// BFS
					while (!queue.isEmpty()) {
						Node curr = queue.poll();

						if (board[curr.r][curr.c] == 1) {
							// 사방탐색하며 큐에 삽입한다.
							int[] dr = { 0, 0, -1, 1 };
							int[] dc = { -1, 1, 0, 0 };
							for (int d = 0; d < 4; d++) {
								int nr = curr.r + dr[d];
								int nc = curr.c + dc[d];

								// 기저 조건
								if (nr < 0 || nc < 0 || nr >= n || nc >= m) {
									continue;
								}
								if (visited[nr][nc]) {
									continue;
								}
								if (board[nr][nc] == 0) {
									continue;
								}

								// 그림의 연결된 부분에 대한 작업들
								queue.add(new Node(nr, nc)); // 큐에 삽입
								visited[nr][nc] = true; // 방문 처리
								size++; // 그림의 넓이 + 1
							}
						}
					} // 그림이 더이상 연결되어 있지 않다면 빈 큐가 되어 while문 종료

					// 그림 하나가 끝났다. -> 가장 넓은 지 확인
					maxSize = Math.max(maxSize, size);
				}
			}
		} // 이중 for문 끝

		// 출력
		System.out.println(cnt);
		System.out.println(maxSize);
	}
}
