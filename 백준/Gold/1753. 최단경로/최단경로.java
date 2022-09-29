import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static final int INF = Integer.MAX_VALUE;
	static int V, E, K; 						// V : 정점의 갯수, E : 간선의 갯수, K : 시작 정점의 번호
	static List<Node>[] adjList; 	// 인접 리스트
	static int[] dist; 					// 최단 길이를 저장할 값들.
	
	static class Node implements Comparable<Node> {
		int v, w;

		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}
	}
	
	// main (Dijkstar Algorithm - PriorityQue)
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		V = sc.nextInt();	// 1 ≤ V ≤ 20,000
		E = sc.nextInt();	// 1 ≤ E ≤ 300,000
		K = sc.nextInt();	// 1 ≤ K ≤ V
		
		adjList = new ArrayList[V+1];
		for(int i = 1 ; i <= V; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		dist = new int[V+1];
		Arrays.fill(dist, INF);
		// 초기화 완료 //
		
		// 입력 받는다.
		for(int i = 0 ; i < E; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			int w = sc.nextInt();
			
			// 유향 그래프임
			adjList[u].add(new Node(v, w));	// 인접 리스트에 넣기
		}
		
		Dijkstra(K);
		
		// 출력
		for(int i = 1; i <= V; i++) {
			if(dist[i] == INF) {
				System.out.println("INF");
			}
			else {
				System.out.println(dist[i]);
			}
		}
	}
	
	private static void Dijkstra(int u) {
		PriorityQueue<Node> pq = new PriorityQueue<>();

		boolean[] visited = new boolean[V+1];

		pq.add(new Node(u, 0)); // 시작 정점
		dist[u] = 0;	// 시작 노드까지의 거리는 0

		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			
			// 방문했다면
			if (visited[curr.v]) {
				continue;
			}
			
			visited[curr.v] = true;	// 방문 처리

			// 현재 꺼낸 노드와 연결된 노드들을 하나씩 가져온다.
			for (Node node : adjList[curr.v]) {
				if (!visited[node.v] && dist[node.v] > dist[curr.v] + node.w) {
					dist[node.v] = dist[curr.v] + node.w;
					pq.add(new Node(node.v, dist[node.v]));
				}
			}
		}	// while 문 끝
	}
}