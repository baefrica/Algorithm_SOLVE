import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;		// 격자판 행의 수 (3 ≤ N ≤ 15)
	static int M;		// 격자판 열의 수 (3 ≤ M ≤ 15)
	static int D;		// 궁수의 공격 거리 제한 (1 ≤ D ≤ 10)
	static int[][] board;
	static boolean[][] visited;	// 공격 당했는 지 보기 위한 배열
	static boolean[][] count;		// 카운팅 되었는지 여부 배열
	static int[][] position;
	static Queue<Node> queue;
	static int kill;	// 죽인 적의 수
	static int killMax;
	static int pCnt = 0;
	
	static class Node {
		int r, c;
		
		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static void BFS(int aLine, int p) {
		if(aLine == 0) {
			return;
		}
		
		queue.add(new Node(aLine, position[p][0]));
		queue.add(new Node(aLine, position[p][1]));
		queue.add(new Node(aLine, position[p][2]));
		
		while(!queue.isEmpty()) {
			// 큐에 들어있는 걸 뽑아서
			Node node = queue.poll();
			
			// 가장 가까우면서 가장 왼쪽인 곳 찾기
			int minDist = Integer.MAX_VALUE;
			int idx = -1;	// 죽일 놈의 행
			int jdx = -1;	// 죽일 놈의 열
			for(int j = 0; j < M; j++) {
				for(int i = 0; i < aLine; i++) {
					// 0이면
					if(board[i][j] == 0) {
						continue;
					}
					// 1이면
					else {
						int dist = Math.abs(node.r - i) + Math.abs(node.c - j);
						
						// 제한 거리 넘으면 패쓰
						if(dist > D) {
							continue;
						}
						// 앞에서 센 것도 넘긴다
						if(count[i][j]) {
							continue;
						}
						// 최소 거리 갱신
						if(minDist > dist) {
							minDist = dist;
							idx = i;
							jdx = j;
						}
					}
				}
			}	// for 문 끝 -> 죽일 놈 찾음
			if(idx != -1 && jdx != -1) {
				visited[idx][jdx] = true;		// 죽였다고 표시
			}
		}	// while 끝
		
//		for(int a = 0; a < N; a++) {
//			System.out.println(Arrays.toString(visited[a]));
//		}
//			System.out.println();
		
		// 죽인 적의 수 카운팅
		for(int i = 0; i < aLine; i++) {
			for(int j = 0; j < M; j++) {
				if(visited[i][j] == true && count[i][j] != true) {
					kill++;
					count[i][j] = true;	// 셌다고 표시
				}
			}
		}
		
		BFS(aLine-1, p);
	}	// BFS 끝
	
	// 조합으로 경우의 수 구하기
	public static int combi(int idx, int sidx) {
		int[] sel = new int[3];
		if (sidx == 3) {
			pCnt++;
	        return 1;
		}
		else if (idx == M) {
			return -1;
		}
		sel[sidx] = idx;
	    combi(idx + 1, sidx + 1);
	    combi(idx + 1, sidx);
	    return pCnt;
	}
	
	// 궁수 위치 배치
	public static void arrange() {
		int idx = 0;
		// 포지션 배열 생성
		position = new int[combi(0, 0)][3];
		for(int i = 0; i < M; i++) {
			for(int j = i+1; j < M; j++) {
				for(int k = j+1; k < M; k++) {
					position[idx][0] = i;
					position[idx][1] = j;
					position[idx][2] = k;
					idx++;
				}
			}
		}
	}
	
	// main
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();		// 격자판 행의 수 (3 ≤ N ≤ 15)
		M = sc.nextInt();		// 격자판 열의 수 (3 ≤ M ≤ 15)
		D = sc.nextInt();		// 궁수의 공격 거리 제한 (1 ≤ D ≤ 10)
		board = new int[N+1][M];		// 격자판의 상태 (0 : 빈 칸, 1 : 적이 있는 칸)
		
		queue = new LinkedList<>();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		// 궁수 배치
		arrange();
		
		killMax = Integer.MIN_VALUE;
		// 궁수 배열의 가짓수 만큼
		for(int i = 0; i < position.length; i++) {
			visited = new boolean[N][M];
			count = new boolean[N][M];
			kill = 0;		// 죽인 적의 수를 리셋
			BFS(N, i);
			// 포지션 별로 죽인 적의 최대 수 나올 때마다 비교해서
			// 궁수의 공격으로 제거할 수 있는 적의 최대 수
			killMax = Math.max(kill, killMax);
		}
		// 최댓값 출력
		System.out.println(killMax);
	}
}