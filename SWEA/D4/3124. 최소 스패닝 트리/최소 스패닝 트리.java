import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
	static int V;		// 정점의 갯수
	static int E;		// 간선의 갯수
		
	static class Edge implements Comparable<Edge> {
		int st, ed, cost;

		public Edge(int st, int ed, int cost) {
			this.st = st;
			this.ed = ed;
			this.cost = cost;
		}

		// 우선순위큐를 활용하기 위해서 기준을 정해준다.
		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}
	}
	
	// main (Prim's Algorithm)
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			V = sc.nextInt();
			E = sc.nextInt();
			
			List<Edge>[] adjList = new ArrayList[V+1];
			for (int i = 1; i < V+1; i++)
				adjList[i] = new ArrayList<>();

			for (int i = 0; i < E; i++) {
				int A = sc.nextInt(); // A : [0] 시작정점
				int B = sc.nextInt(); // B : [1] 도착정점
				int C = sc.nextInt(); // C : [2] 가중치

				adjList[A].add(new Edge(A, B, C));
				adjList[B].add(new Edge(B, A, C));
			}
			
			// 방문처리용
			boolean[] visited = new boolean[V+1];
			// 우선순위 큐
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			
			// 시작 정점을 하나 뽑고 방문처리
//			for(int i = 0 ; i<adjList[0].size(); i++)
//				pq.add(adjList[0].get(i));
			pq.addAll(adjList[1]);
			visited[1] = true;

			long ans = 0;	// 정답을 뽑아내기 위한 값
			int pick = 1; // 확보한 정점의 갯수

			// pick < V
			// 연결된 간선을 하나 뽑는다.
			while (pick != V) {
				Edge edge = pq.poll();
				
				// 이미 방문했다면 패스
				if (visited[edge.ed]) {
					continue;
				}
				
				ans += edge.cost;
				pq.addAll(adjList[edge.ed]);
				visited[edge.ed] = true;		// 방문처리
				pick++;	
			}
			
			System.out.println("#" + tc + " " + ans);
		}	// 테케 끝
	}
}