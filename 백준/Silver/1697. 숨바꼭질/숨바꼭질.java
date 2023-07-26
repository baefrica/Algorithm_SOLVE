import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();

		Queue<Integer> queue = new LinkedList<>();
		// 시간 초과 : 방문처리 배열을 만들어주어야한다.
		boolean[] visited = new boolean[100001];

		queue.add(N);
		visited[N] = true;

		int cnt = -1; // 수빈이 위치를 뽑는 것부터 시작점이기 때문
		while (!queue.isEmpty()) {
			int size = queue.size();
			cnt++;

			for (int s = 0; s < size; s++) {
				int curr = queue.poll();

				if (curr == K) {
					System.out.println(cnt);
					queue.clear();
					break;
				}

				// 걷기 or 순간이동
				int bWalk = (curr - 1);
				int fWalk = (curr + 1);
				int move = (curr * 2);
				// 조건 : visited 배열에 속하고 방문하지 않은 점일 때
				if (bWalk >= 0 && bWalk <= 100000 && !visited[bWalk]) {
					queue.add(bWalk);
					visited[bWalk] = true;
				}
				if (fWalk >= 0 && fWalk <= 100000 && !visited[fWalk]) {
					queue.add(fWalk);
					visited[fWalk] = true;
				}
				if (move >= 0 && move <= 100000 && !visited[move]) {
					queue.add(move);
					visited[move] = true;
				}
			} // for문 끝
		} // while문 끝
	}
}