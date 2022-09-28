import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
	static int V;		// 정점의 갯수
	static int E;		// 간선의 갯수
	static int[] p;	// 대표를 저장할 배열
	
	private static int findSet(int x) {
		// 패쓰 컴프레션
		if (x != p[x]) {
			p[x] = findSet(p[x]);
		}
		return p[x];
	}

	private static void union(int x, int y) {
		p[findSet(y)] = findSet(x); //교재 정석
	}
	
	// main (Kruskal's Algorithm)
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			V = sc.nextInt();
			E = sc.nextInt();
			
			// 간선의 배열을 저장하기 위해서
			int[][] edges = new int[E][3];
			// 입력
			for (int i = 0; i < E; i++) {
				edges[i][0] = sc.nextInt(); // A : [0] 시작정점
				edges[i][1] = sc.nextInt(); // B : [1] 도착정점
				edges[i][2] = sc.nextInt(); // C : [2] 가중치
			}
			
			// 오름차순
			Arrays.sort
				(edges, new Comparator<int[]>() {
					// 음수 / 양수+0 에 따라 값을 바꿀지 말지 결정을 한다.
					@Override
					public int compare(int[] o1, int[] o2) {
						return o1[2] - o2[2];
					}
				}
			);
			
			p = new int[V+1]; // 대표를 저장할 친구
			// make-set을 해야겠다. (나 자신을 대표로 초기화 하자)
			for (int i = 0; i < V; i++) {
				p[i] = i;
			} // make-set 과정 끝
			
			// mst 를 만들기 위해서 간선을 선택하자.
			long ans = 0;
			// 간선은 V-1 를 뽑는 순간 멈춘다.
			int pick = 0;
			
			for (int i = 0; i < E; i++) {
				// i번째 간선을 뽑아서 두 정점의 대표를 확인다.
				// 대표가 같다면 pass / 다르다면 union (ans 추가 / pick 추가)
				int px = findSet(edges[i][0]);
				int py = findSet(edges[i][1]);

				if (px != py) {
					union(px, py);
					ans += edges[i][2];
					pick++;
				}

				if (pick == (V - 1))
					break;
			}
			
			System.out.println("#" + tc + " " + ans);
		}	// 테케 끝
	}
}