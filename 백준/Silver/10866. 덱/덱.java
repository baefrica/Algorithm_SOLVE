import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		Deque<Integer> deque = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			switch (st.nextToken()) {
			case "push_front":
				deque.offerFirst(Integer.parseInt(st.nextToken()));
				break;

			case "push_back":
				deque.offerLast(Integer.parseInt(st.nextToken()));
				break;

			case "pop_front":
				if (deque.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(deque.pollFirst()).append("\n");
				}

				break;

			case "pop_back":
				if (deque.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(deque.pollLast()).append("\n");
				}

				break;

			case "size":
				sb.append(deque.size()).append("\n");
				break;

			case "empty":
				if (deque.isEmpty()) {
					sb.append(1).append("\n");
				} else {
					sb.append(0).append("\n");
				}

				break;

			case "front":
				if (deque.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(deque.peekFirst()).append("\n");
				}

				break;

			case "back":
				if (deque.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(deque.peekLast()).append("\n");
				}

				break;
			} // switch문 끝
		} // for문 끝

		// 출력
		System.out.print(sb);
	}
}
