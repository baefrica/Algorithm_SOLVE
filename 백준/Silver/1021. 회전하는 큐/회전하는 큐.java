import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 큐의 크기
		int M = sc.nextInt(); // 뽑아내려고 하는 수의 개수

		LinkedList<Integer> deque = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			deque.offer(i);
		}

		int cnt = 0;
		for (int i = 0; i < M; i++) {
			// 뽑고싶은 숫자
			int num = sc.nextInt();

			while (true) {
				// 첫번째 원소를 뽑아낸다.
				if (deque.peek() == num) {
					deque.poll();
					break;
				} else {
					// 덱의 중앙값을 찾는다.
					double mid = deque.size() / 2;

					// 앞이 더 가까울 때
					if (deque.indexOf(num) <= mid) {
						int tmp = deque.pollFirst();
						deque.offerLast(tmp);
					}
					// 뒤가 더 가까울 때
					else {
						int tmp = deque.pollLast();
						deque.offerFirst(tmp);
					}
					cnt++;
				}
			} // while문 끝
		} // for문 끝

		System.out.println(cnt);
	}
}