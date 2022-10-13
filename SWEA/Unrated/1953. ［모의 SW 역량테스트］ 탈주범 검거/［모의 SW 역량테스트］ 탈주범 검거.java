import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static class Node {
		int r, c;
		
		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int x = 1; x <= T; x++) {
			int N = sc.nextInt();		// 지하 터널 지도의 세로 크기
			int M = sc.nextInt();		// 지하 터널 지도의 가로 크기
			int R = sc.nextInt();		// 맨홀 뚜껑이 위치한장소의 세로 위치
			int C = sc.nextInt();		// 맨홀 뚜껑이 위치한장소의 가로 위치
			int L = sc.nextInt();		// 탈출 후 소요된 시간
			
			int[][] map = new int[N][M];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			boolean[][] visited = new boolean[N][M];		// 방문체크 배열
			
			// bfs 할려고 큐 생성
			Queue<Node> queue = new LinkedList<>();
			
			// 맨홀 뚜껑 위치부터 시작이고 방문체크
			queue.add(new Node(R, C));
			visited[R][C] = true;
			
			int cnt = 1;		// 한시간 경과부터 시작
			
			// 탈주범이 도망간 시간 채우면 종료
			while(cnt < L) {
				int size = queue.size();
				cnt++;	// 큐 사이즈만큼 한 싸이클 돌고나면 한시간 경과
//				System.out.println(cnt);
				
				for(int i = 0; i < size; i++) {
					Node node = queue.poll();
					
					switch(map[node.r][node.c]) {
					// 1번. 상, 하, 좌, 우에 있는 터널과 연결
					case 1 :
						int[] dr1 = {-1, 1, 0, 0};
						int[] dc1 = {0, 0, -1, 1};
						
						for(int d = 0; d < 4; d++) {
							int nr = node.r + dr1[d];
							int nc = node.c + dc1[d];
							
							// 경계 넘어갔을 때 체크
							if(nr < 0 || nc < 0 || nr >= N || nc >= M) {
								continue;
							}
							// 방문했거나 터널이 없는 장소
							if(visited[nr][nc] == true || map[nr][nc] == 0) {
								continue;
							}
							// 각각의 경우에 갈 수 있는 터널 체크
							if(d == 0) {
								if(map[nr][nc] == 3 || map[nr][nc] == 4 || map[nr][nc] == 7) {
									continue;
								}
							}
							else if(d == 1) {
								if(map[nr][nc] == 3 || map[nr][nc] == 5 || map[nr][nc] == 6) {
									continue;
								}
							}
							else if(d == 2) {
								if(map[nr][nc] == 2 || map[nr][nc] == 6 || map[nr][nc] == 7) {
									continue;
								}
							}
							else {
								if(map[nr][nc] == 2 || map[nr][nc] == 4 || map[nr][nc] == 5) {
									continue;
								}
							}
							
							// 넘어갈 수 있는 터널이면 큐에 삽입
							queue.add(new Node(nr, nc));
							// 갈 수 있으니 방문체크부터
							visited[nr][nc] = true;
						}
						break;
						
						// 지금부터 7번까지 1번 경우와 똑같이 생각..
						// 2번. 상, 하에 있는 터널과 연결
					case 2 :
						int[] dr2 = {-1, 1};
						int[] dc2 = {0, 0};
						
						for(int d = 0; d < 2; d++) {
							int nr = node.r + dr2[d];
							int nc = node.c + dc2[d];
							
							if(nr < 0 || nc < 0 || nr >= N || nc >= M) {
								continue;
							}
							// 방문했거나 터널이 없는 장소
							if(visited[nr][nc] == true || map[nr][nc] == 0) {
								continue;
							}
							
							if(d == 0) {
								if(map[nr][nc] == 3 || map[nr][nc] == 4 || map[nr][nc] == 7) {
									continue;
								}
							}
							else {
								if(map[nr][nc] == 3 || map[nr][nc] == 5 || map[nr][nc] == 6) {
									continue;
								}
							}
							
							queue.add(new Node(nr, nc));
							visited[nr][nc] = true;
						}
						break;
						
						// 3번. 좌, 우에 있는 터널과 연결
					case 3 :
						int[] dr3 = {0, 0};
						int[] dc3 = {-1, 1};
						
						for(int d = 0; d < 2; d++) {
							int nr = node.r + dr3[d];
							int nc = node.c + dc3[d];
							
							if(nr < 0 || nc < 0 || nr >= N || nc >= M) {
								continue;
							}
							// 방문했거나 터널이 없는 장소
							if(visited[nr][nc] == true || map[nr][nc] == 0) {
								continue;
							}
							
							if(d == 0) {
								if(map[nr][nc] == 2 || map[nr][nc] == 6 || map[nr][nc] == 7) {
									continue;
								}
							}
							else {
								if(map[nr][nc] == 2 || map[nr][nc] == 4 || map[nr][nc] == 5) {
									continue;
								}
							}
							
							queue.add(new Node(nr, nc));
							visited[nr][nc] = true;
						}
						break;
						
						// 4번. 상, 우에 있는 터널과 연결
					case 4 :
						int[] dr4 = {-1, 0};
						int[] dc4 = {0, 1};
						
						for(int d = 0; d < 2; d++) {
							int nr = node.r + dr4[d];
							int nc = node.c + dc4[d];
							
							if(nr < 0 || nc < 0 || nr >= N || nc >= M) {
								continue;
							}
							// 방문했거나 터널이 없는 장소
							if(visited[nr][nc] == true || map[nr][nc] == 0) {
								continue;
							}
							
							if(d == 0) {
								if(map[nr][nc] == 3 || map[nr][nc] == 4 || map[nr][nc] == 7) {
									continue;
								}
							}
							else {
								if(map[nr][nc] == 2 || map[nr][nc] == 4 || map[nr][nc] == 5) {
									continue;
								}
							}
							
							queue.add(new Node(nr, nc));
							visited[nr][nc] = true;
						}
						break;
						
						// 5번. 하, 우에 있는 터널과 연결
					case 5 :
						int[] dr5 = {1, 0};
						int[] dc5 = {0, 1};
						
						for(int d = 0; d < 2; d++) {
							int nr = node.r + dr5[d];
							int nc = node.c + dc5[d];
							
							if(nr < 0 || nc < 0 || nr >= N || nc >= M) {
								continue;
							}
							// 방문했거나 터널이 없는 장소
							if(visited[nr][nc] == true || map[nr][nc] == 0) {
								continue;
							}
							
							if(d == 0) {
								if(map[nr][nc] == 3 || map[nr][nc] == 5 || map[nr][nc] == 6) {
									continue;
								}
							}
							else {
								if(map[nr][nc] == 2 || map[nr][nc] == 4 || map[nr][nc] == 5) {
									continue;
								}
							}
							
							queue.add(new Node(nr, nc));
							visited[nr][nc] = true;
						}
						break;
						
						// 6번. 하, 좌에 있는 터널과 연결
					case 6 :
						int[] dr6 = {1, 0};
						int[] dc6 = {0, -1};
						
						for(int d = 0; d < 2; d++) {
							int nr = node.r + dr6[d];
							int nc = node.c + dc6[d];
							
							if(nr < 0 || nc < 0 || nr >= N || nc >= M) {
								continue;
							}
							// 방문했거나 터널이 없는 장소
							if(visited[nr][nc] == true || map[nr][nc] == 0) {
								continue;
							}
							
							if(d == 0) {
								if(map[nr][nc] == 3 || map[nr][nc] == 5 || map[nr][nc] == 6) {
									continue;
								}
							}
							else {
								if(map[nr][nc] == 2 || map[nr][nc] == 6 || map[nr][nc] == 7) {
									continue;
								}
							}
							
							queue.add(new Node(nr, nc));
							visited[nr][nc] = true;
						}
						break;
						
						// 7번. 상, 좌에 있는 터널과 연결
					case 7 :
						int[] dr7 = {-1, 0};
						int[] dc7 = {0, -1};
						
						for(int d = 0; d < 2; d++) {
							int nr = node.r + dr7[d];
							int nc = node.c + dc7[d];
							
							if(nr < 0 || nc < 0 || nr >= N || nc >= M) {
								continue;
							}
							// 방문했거나 터널이 없는 장소
							if(visited[nr][nc] == true || map[nr][nc] == 0) {
								continue;
							}
							
							if(d == 0) {
								if(map[nr][nc] == 3 || map[nr][nc] == 4 || map[nr][nc] == 7) {
									continue;
								}
							}
							else {
								if(map[nr][nc] == 2 || map[nr][nc] == 6 || map[nr][nc] == 7) {
									continue;
								}
							}
							
							queue.add(new Node(nr, nc));
							visited[nr][nc] = true;
						}
						break;
					}	// switch문 종료
				}	// size 만큼..종료
				
			}	// while 문 종료
			
			// 위치할 수 있는 곳을 true 로 다 바까났으니 마지막에 세어주기만 하면 끝
			int ans = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(visited[i][j] == true) {
						ans++;
					}
				}
			}
			
			System.out.println("#" + x + " " + ans);
		}	// 테케 끝
	}
}