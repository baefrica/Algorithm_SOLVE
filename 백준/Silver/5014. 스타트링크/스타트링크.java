import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int F = sc.nextInt(); // 건물 총 층 수
		int S = sc.nextInt(); // 강호 현재 위치
		int G = sc.nextInt(); // 스타트링크 위치
		int U = sc.nextInt(); // 위로 U층 가는 버튼
		int D = sc.nextInt(); // 아래로 D층 가는 버튼

		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[F + 1];
		boolean flag = false;
		// 다음 층으로 가기 위해 눌러야 하는 버튼의 수라는 점에 유의!
		int cnt = -1;

		queue.add(S);
		visited[S] = true;

		while (!queue.isEmpty()) {
			int size = queue.size();
			cnt++;

			for (int s = 0; s < size; s++) {
				int curr = queue.poll();

				// 탈출 조건
				if (curr == G) {
					flag = true;
					queue.clear();
					break;
				}

				int up = curr + U;
				int down = curr - D;

				if (up <= F && !visited[up]) {
					queue.add(up);
					visited[up] = true;
				}
				if (down > 0 && !visited[down]) {
					queue.add(down);
					visited[down] = true;
				}
			}
		} // while문 끝

		if (flag) {
			System.out.println(cnt);
		} else {
			System.out.println("use the stairs");
		}
	}
}