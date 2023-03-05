import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			// 반례를 통해 큐를 테케 for 문 안에서 생성해야한다는 것을 깨달음
			Queue<int[]> queue = new LinkedList<>();
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[] important = new int[N];

			for (int i = 0; i < N; i++) {
				important[i] = sc.nextInt();
				queue.offer(new int[] { i, important[i] });
			}

			Arrays.sort(important);

			// 판별 도구
			int maxNum = N - 1;
			int cnt = 0;
			while (true) {
				int[] pollNum = queue.poll();
				// 중요도가 제일 높다
				if (pollNum[1] == important[maxNum]) {
					cnt++;

					// while문 탈출
					if (pollNum[0] == M) {
						System.out.println(cnt);
						break;
					}
					// 뽑았지만 내가 찾는 문서가 아니다
					else {
						maxNum--;
					}
				}
				// 뽑은 거보다 더 중요도가 높은 게 있다
				else {
					queue.offer(pollNum);
				}
			} // while문 끝
		}
	}
}
