import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	// 노드 생성
	public static class Node {
		int r;
		int c;

		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int M = sc.nextInt();
			int N = sc.nextInt();
			int K = sc.nextInt();

			// 배추판 생성
			int[][] board = new int[N][M];
			for (int k = 0; k < K; k++) {
				int X = sc.nextInt();
				int Y = sc.nextInt();

				board[Y][X] = 1;
			}

			// 큐 생성
			Queue<Node> queue = new LinkedList<>();
			// 벌레 카운팅
			int cnt = 0;

			// 1을 찾으러 가보자
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					// 1을 찾으면
					if (board[i][j] == 1) {
						// 벌레 한마리 추가
						cnt++;
						// 중심되는 배추
						queue.add(new Node(i, j));
						// 넣은 배추는 0으로 만들고 (메모리 초과가 발생해서 큐에 넣을 때 방문처리)
						board[i][j] = 0;

						// 중심 배추를 기준으로 사방탐색하며 인접한 배추들을 큐에 담는다.
						// 큐에 배추들이 다 사라지면 하나의 벌레가 갈 수 있는 배추들 모두 체크한 경우이다.
						while (!queue.isEmpty()) {
							// 배추를 하나 큐에서 빼고
							Node cur = queue.poll();

							// 뺀 배추를 중심으로 사방탐색
							int[] dr = { 0, 0, -1, 1 };
							int[] dc = { -1, 1, 0, 0 };

							for (int d = 0; d < 4; d++) {
								int nr = cur.r + dr[d];
								int nc = cur.c + dc[d];

								// 경계 체크
								if (nr < 0 || nc < 0 || nr >= N || nc >= M) {
									continue;
								}

								// 1이면 큐에 담는다.
								if (board[nr][nc] == 1) {
									queue.add(new Node(nr, nc));
									// 넣은 배추는 0으로 만들고 (메모리 초과가 발생해서 큐에 넣을 때 방문처리)
									board[nr][nc] = 0;

//									for (int a = 0; a < N; a++) {
//										System.out.println(Arrays.toString(board[a]));
//									}
//									System.out.println("큐는?");
//									System.out.println(queue);
//									System.out.println("다음다음다음");
								}
							}
						} // while문 끝
					}
				}
			}

			System.out.println(cnt);
		} // 테케 끝
	} // main 끝
}