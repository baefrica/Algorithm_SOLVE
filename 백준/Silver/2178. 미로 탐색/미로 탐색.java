import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int cnt;
	static boolean visited[][];
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static class Node {
		int r, c;
		
		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	// main	// bfs
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		char[][] map = new char[N][M];
		for(int i = 0; i < N; i++){
			String line = sc.next();
			for(int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j);
			}
		}
		
		visited = new boolean[N][M];
		Queue<Node> queue = new LinkedList<>();
				
		// 시작점 체크
		int r = 0;
		int c = 0;
		cnt = 0;
		queue.add(new Node(r, c));
		visited[r][c] = true;
		cnt++;
		
		Loop :
		while(!queue.isEmpty()) {
			// 큐의 크기만큼 다 빼는 게 한 카운팅
			int size = queue.size();
			for(int i = 0; i < size; i++) {
				// 큐에 들어있는 맨 위에 걸 빼낸다
				Node node = queue.poll();
				
				// 종료
				if(node.r == (N - 1) && node.c == (M - 1)) {
					System.out.println(cnt);
					break Loop;
				}
				
				int nr = 0;
				int nc = 0;
				for(int d = 0; d < 4; d++) {
					nr = node.r + dr[d];
					nc = node.c + dc[d];
					
					// 패스조건
					if(nr < 0 || nc < 0 || nr >= N || nc >= M) {
						continue;
					}
					if(map[nr][nc] == '0' || visited[nr][nc]) {
						continue;
					}
					//
					
					queue.add(new Node(nr, nc));
					visited[nr][nc] = true;
				}
			}
			cnt++;
		}	// while 문
	}
}