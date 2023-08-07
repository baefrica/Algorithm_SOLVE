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

		int N = sc.nextInt();
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		Queue<Node> queue = new LinkedList<>();
		boolean[][] visited = new boolean[N][N];
		int[] dr = { 0, 0, -1, 1 };
		int[] dc = { -1, 1, 0, 0 };

		// 섬을 구분하기 위한 작업 -> 섬에 아이디를 부여하는 라벨링 작업
		int idx = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j] && map[i][j] == 1) {
					idx++;
					queue.add(new Node(i, j));
					visited[i][j] = true;
					map[i][j] = idx;

					while (!queue.isEmpty()) {
						Node curr = queue.poll();

						for (int d = 0; d < 4; d++) {
							int nr = curr.r + dr[d];
							int nc = curr.c + dc[d];

							// 기저 조건
							if (nr < 0 || nc < 0 || nr >= N || nc >= N) {
								continue;
							}
							if (visited[nr][nc]) {
								continue;
							}

							if (map[nr][nc] == 1) {
								queue.add(new Node(nr, nc));
								visited[nr][nc] = true;
								map[nr][nc] = idx;
							}
						}
					}
				}
			}
		}

//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}

		Queue<Node> bridge = new LinkedList<>();
		boolean[][] visitedBridge;	// 메모리 초과 날까봐 다리 방문 처리 배열
		int res = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 시작점
				if (map[i][j] > 0) {
					int cnt = -1; // 다리길이 시작
					visitedBridge = new boolean[N][N];
					queue.add(new Node(i, j));
					visitedBridge[i][j] = true;

					while (!queue.isEmpty()) {
						int size = queue.size();
						cnt++;

						for (int s = 0; s < size; s++) {
							Node curr = queue.poll();

							// 종료 조건 : 다리 완성!
							// 큐 뽑았는데 라벨링 아이디가 나보다 큰 다른 섬이다.
							if (map[curr.r][curr.c] > map[i][j]) {
								res = Math.min(res, cnt - 1);
								queue.clear();
								break;
							}

							for (int d = 0; d < 4; d++) {
								int nr = curr.r + dr[d];
								int nc = curr.c + dc[d];

								// 기저 조건
								if (nr < 0 || nc < 0 || nr >= N || nc >= N) { // 경계 밖일 때
									continue;
								}
								if (visitedBridge[nr][nc]) {
									continue;
								}
								
								// 바다 or 라벨링 아이디가 자기보다 큰 다른 섬
								if (map[nr][nc] == 0 || map[nr][nc] > map[i][j]) {
									queue.add(new Node(nr, nc));
									visitedBridge[nr][nc] = true;
								}
							}
						}
					} // while문 끝
				}
			}
		}

		System.out.println(res);
	}
}