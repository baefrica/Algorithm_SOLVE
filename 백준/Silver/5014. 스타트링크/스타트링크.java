import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 리팩토링한 코드 !!
class Node {
	int floor, cnt;

	Node(int floor, int cnt) {
		this.floor = floor;
		this.cnt = cnt;
	}
}

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int F = sc.nextInt(); // 건물 총 층 수
		int S = sc.nextInt(); // 강호 현재 위치
		int G = sc.nextInt(); // 스타트링크 위치
		int U = sc.nextInt(); // 위로 U층 가는 버튼
		int D = sc.nextInt(); // 아래로 D층 가는 버튼

		Queue<Node> queue = new LinkedList<>();
		boolean[] visited = new boolean[F + 1];
		boolean flag = false;

		// cnt : 다음 층으로 가기 위해 눌러야 하는 버튼의 수라는 점에 유의 !!
		queue.add(new Node(S, 0));
		visited[S] = true;

		while (!queue.isEmpty()) {
			Node curr = queue.poll();

			// 탈출 조건
			if (curr.floor == G) {
				System.out.println(curr.cnt);
				flag = true;
				queue.clear();
				break;
			}

			int up = curr.floor + U;
			int down = curr.floor - D;

			if (up <= F && !visited[up]) {
				queue.add(new Node(up, curr.cnt + 1));
				visited[up] = true;
			}
			if (down > 0 && !visited[down]) {
				queue.add(new Node(down, curr.cnt + 1));
				visited[down] = true;
			}
		} // while문 끝

		if (!flag) {
			System.out.println("use the stairs");
		}
	}
}