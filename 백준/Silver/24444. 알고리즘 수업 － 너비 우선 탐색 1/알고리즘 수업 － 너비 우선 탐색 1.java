import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		int R = sc.nextInt();

		int[] visited = new int[N + 1];
		List<Integer>[] edge = new LinkedList[N + 1];

		for (int i = 1; i <= N; i++) {
			edge[i] = new LinkedList<>();
		}

		for (int i = 0; i < M; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();

			edge[u].add(v);
			edge[v].add(u);
		}

		// 각 정점으로부터 연결된 간선 리스트를 오름차순 정렬
		for (int i = 1; i < edge.length; i++) {
			Collections.sort(edge[i]);
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
			System.out.println(visited[i]);
		}
	}
}