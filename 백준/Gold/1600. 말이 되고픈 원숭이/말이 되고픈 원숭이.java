import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int K;
	static int W;
	static int H;
	static int[][] map;
	static boolean[][][] visited;
	//visited[0][0][0] : (0, 0)에서 말처럼 0번 뛴 상태에서 방문
    //visited[0][0][1] : (0, 0)에서 말처럼 1번 뛴 상태에서 방문
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	static int[] hdr = {-1, -2, -2, -1, 1, 2, 2, 1};
	static int[] hdc = {-2, -1, 1, 2, 2, 1, -1, -2};
	
	public static class Node {
		int r, c;
		int cnt;
		int horseCnt;
		
		Node(int r, int c, int cnt, int horseCnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.horseCnt = horseCnt;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		K = sc.nextInt();
		W = sc.nextInt();
		H = sc.nextInt();
		
		map = new int[H][W];
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < W; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		visited = new boolean[H][W][K+1];
		Queue<Node> queue = new LinkedList<>();
		
		queue.add(new Node(0, 0, 0, 0));
		visited[0][0][0] = true;
		
		boolean flag = true;
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			
			// 종료
			if(node.r == H-1 && node.c == W-1) {
				flag = false;
				System.out.println(node.cnt);
				break;
			}
			
			int nr = 0;
			int nc = 0;
			
			// 말처럼 움직일 수 있다
			if(node.horseCnt < K) {
				for(int d = 0; d < 8; d++) {
					nr = node.r + hdr[d];
					nc = node.c + hdc[d];
					
					if(nr < 0 || nc < 0 || nr >= H || nc >= W) {
						continue;
					}
					if(visited[nr][nc][node.horseCnt+1] || map[nr][nc] == 1) {
						continue;
					}
					
					queue.add(new Node(nr, nc, node.cnt+1, node.horseCnt+1));
					visited[nr][nc][node.horseCnt+1] = true;
				}
			}
			
			for(int d = 0; d < 4; d++) {
				nr = node.r + dr[d];
				nc = node.c + dc[d];
				
				if(nr < 0 || nc < 0 || nr >= H || nc >= W) {
					continue;
				}
				if(visited[nr][nc][node.horseCnt] || map[nr][nc] == 1) {
					continue;
				}
				
				queue.add(new Node(nr, nc, node.cnt+1, node.horseCnt));
				visited[nr][nc][node.horseCnt] = true;
			}
		}	// while 끝
		
		if(flag == true) {
			System.out.println(-1);
		}
	}
}