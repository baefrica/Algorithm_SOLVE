import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static char[][] map;
	static int[][] minTime;	// 도착한 데 까지의 최소시간을 저장
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static class Node {
		int r, c;
		
		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	// BFS 써보자
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int C = 1; C <= T; C++) {
			int N = sc.nextInt();	// 지도 크기
			map = new char[N][N];
			minTime = new int[N][N];
			// 지도 입력받고
			for(int i = 0; i < N; i++) {
				String str = sc.next();
				for(int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j);
					minTime[i][j] = Integer.MAX_VALUE;
				}
			}
			
			Queue<Node> queue = new LinkedList<>();
			int recovTime = Integer.MAX_VALUE;
			
			queue.add(new Node(0, 0));
			minTime[0][0] = 0;
			
			while(!queue.isEmpty()) {
				Node node = queue.poll();
				
				// 종료
				if(node.r == N-1 && node.c == N-1) {
					// 최소 시간이라면 갱신 !
					if(minTime[N-1][N-1] < recovTime) {
						recovTime = minTime[N-1][N-1];
					}
				}
				
				for(int d = 0; d < 4; d++) {
					int nr = node.r + dr[d];
					int nc = node.c + dc[d];
				
					if(nr < 0 || nc < 0 || nr >= N || nc >= N) {
						continue;
					}
					
					// 최소일 때만 복구 작업 시간 추가
					if(minTime[nr][nc] > minTime[node.r][node.c] + (map[nr][nc]-48)) {
						minTime[nr][nc] = minTime[node.r][node.c] + (map[nr][nc]-48);
						queue.add(new Node(nr, nc));
					}
				}
			}	// while 끝
			
			System.out.println("#" + C + " " + recovTime);
		}	// 테케 끝
	}
}