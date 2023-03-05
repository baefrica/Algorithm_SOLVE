import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int N = sc.nextInt();

		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			queue.offer(i);
		}

		while (true) {
			if (queue.size() == 1) {
				sb.append(queue.poll());
				System.out.println(sb);
				break;
			}

			// 1. 하나 버리고
			sb.append(queue.poll() + " ");
			// 2. 하나 맨 밑으로 내린다
			queue.offer(queue.poll());

		} // while문 끝
	}
}