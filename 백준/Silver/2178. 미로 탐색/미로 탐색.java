import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
	int r;
	int c;

	Node(int r, int c) {
		this.r = r;
		this.c = c;
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 세로 길이
		int M = Integer.parseInt(st.nextToken()); // 가로 길이
		int[][] board = new int[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				board[i][j] = str.charAt(j) - '0';
			}
		}

		Queue<Node> queue = new LinkedList<>(); // 큐 생성
		boolean[][] visited = new boolean[N][M]; // 방문 처리 배열 생성

		queue.add(new Node(0, 0));
		visited[0][0] = true;
		int cnt = 0;
		int cntMIN = Integer.MAX_VALUE;

		// BFS
		while (!queue.isEmpty()) {
			int size = queue.size(); // 큐의 사이즈
			cnt++;

			for (int s = 0; s < size; s++) {
				Node curr = queue.poll();

				// 사방 탐색
				int[] dr = { 0, 0, -1, 1 };
				int[] dc = { -1, 1, 0, 0 };
				for (int d = 0; d < 4; d++) {
					int nr = curr.r + dr[d];
					int nc = curr.c + dc[d];
					
					// 최소의 칸 수 계산
					if (nr == N - 1 && nc == M - 1) {
						cntMIN = Math.min(cntMIN, cnt + 1);
					}

					// 기저 조건
					if (nr < 0 || nc < 0 || nr >= N || nc >= M) {
						continue;
					}
					if (visited[nr][nc]) {
						continue;
					}
					if (board[nr][nc] == 0) {
						continue;
					}

					queue.add(new Node(nr, nc)); // 큐에 삽입
					visited[nr][nc] = true; // 방문 처리
				}
			}
		} // 빈 큐가 되어 while문 종료

		System.out.println(cntMIN);
	}
}