import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node {
	int num, cnt;

	Node(int num, int cnt) {
		this.num = num;
		this.cnt = cnt;
	}
}

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();

		Queue<Node> queue = new LinkedList<>();
		boolean[] visited = new boolean[100001];

		queue.add(new Node(N, 0));
		visited[N] = true;
		int next;

		while (!queue.isEmpty()) {
			Node curr = queue.poll();

			// 동생을 찾았다.
			if (curr.num == K) {
				System.out.println(curr.cnt);
				break;
			}

			// 0초 후 순간이동
			next = curr.num * 2;
			if (next >= 0 && next < 100001 && !visited[next]) { // next 범위 체크 중요!!
				queue.add(new Node(next, curr.cnt));
				visited[next] = true;
			}

			// 1초 후 걷기이동
			next = curr.num - 1;
			if (next >= 0 && next < 100001 && !visited[next]) {
				queue.add(new Node(next, curr.cnt + 1));
				visited[next] = true;
			}
			next = curr.num + 1;
			if (next >= 0 && next < 100001 && !visited[next]) {
				queue.add(new Node(next, curr.cnt + 1));
				visited[next] = true;
			}
		}
	}
}