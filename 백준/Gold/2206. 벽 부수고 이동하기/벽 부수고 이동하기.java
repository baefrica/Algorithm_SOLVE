import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int cnt;
	static boolean visited[][][];
	// visited[][][0] 은 안 부쉈을 때 보는 배열
	// visited[][][1] 은 부쉈을 때 보는 배열
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static Node node;
	
	public static class Node {
		int r, c;
		boolean isBreak;
		int cnt;
		
		Node(int r, int c, boolean isBreak, int cnt) {
			this.r = r;
			this.c = c;
			this.isBreak = isBreak;
			this.cnt = cnt;
		}
	}
	
	// main
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
				
		int N = sc.nextInt();
		int M = sc.nextInt();
		char[][] map = new char[N][M];
		for(int i = 0; i < N; i++){
			String line = sc.next();
			for(int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j);
			}
		}
		
		visited = new boolean[N][M][2];
		Queue<Node> queue = new LinkedList<>();
				
		// 시작점 체크
		int r = 0;
		int c = 0;
		cnt = 1;
		queue.add(new Node(r, c, false, cnt));
		visited[r][c][0] = true;
		
		boolean flag = true;
		Loop :
		while(!queue.isEmpty()) {
			// 큐에 들어있는 맨 위에 걸 빼낸다
			node = queue.poll();
			
			// 종료
			if(node.r == (N - 1) && node.c == (M - 1)) {
				flag = false;
				break Loop;
			}
			
			int nr = 0;
			int nc = 0;
			for(int d = 0; d < 4; d++) {
				nr = node.r + dr[d];
				nc = node.c + dc[d];
				// 패스조건 (경계를 넘거나 방문한 경우엔 여기서 다 걸러짐)
				if(nr < 0 || nc < 0 || nr >= N || nc >= M) {
					continue;
				}
				// 패스조건 끝
				
				// 벽을 만났다
				if(map[nr][nc] == '1') {
					// 부순 적이 없다면 뿌신다
					if(node.isBreak == false) {
						visited[nr][nc][1] = true;
						queue.add(new Node(nr, nc, true, node.cnt+1));
					}
					// 부순 적이 있다면
					else {
						continue;
					}
				}
				// 벽이 아니다
				else {
					// 부순 적이 없다면
					if(node.isBreak == false) {
						if(!visited[nr][nc][0]) {
							visited[nr][nc][0] = true;
							queue.add(new Node(nr, nc, false, node.cnt+1));
						}
					}
					// 부순 적이 있다면
					else {
						if(!visited[nr][nc][1]) {
							visited[nr][nc][1] = true;
							queue.add(new Node(nr, nc, true, node.cnt+1));
						}
					}
				}
			}
		}	// while 문
		
		// 출력
		if(flag == true) {
			sb.append(-1);
		}
		else {
			sb.append(node.cnt);
		}
		
		System.out.println(sb);
	}	// main 끝
}