import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		int[] visited = new int[N + 1];
		List<Integer>[] edge = new LinkedList[N + 1];

		for (int i = 1; i <= N; i++) {
			edge[i] = new LinkedList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			edge[u].add(v);
			edge[v].add(u);
		}

		// 각 정점으로부터 연결된 간선 리스트를 오름차순 정렬
		for (int i = 1; i < edge.length; i++) {
			Collections.sort(edge[i], Collections.reverseOrder());
		}

		Queue<Integer> queue = new LinkedList<>();
		int cnt = 0;

		queue.add(R);
		visited[R] = ++cnt;

		while (!queue.isEmpty()) {
			int curr = queue.poll();

			// 다음 정점들 큐에 넣기
			for (int i : edge[curr]) {
				if (visited[i] == 0) {
					queue.add(i);
					visited[i] = ++cnt;
				}
			}
		} // while문 끝

		// 출력
		for (int i = 1; i < visited.length; i++) {
			sb.append(visited[i]).append("\n");
		}

		System.out.println(sb);
	}
}