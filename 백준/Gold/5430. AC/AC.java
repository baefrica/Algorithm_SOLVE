import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 0; tc < T; tc++) {
			String p = br.readLine();
			int n = Integer.parseInt(br.readLine());
			String array = br.readLine();

			// 배열에 들어가있는 정수들을 입력받고 슬라이싱한다.
			StringTokenizer st = new StringTokenizer(array.substring(1, array.length() - 1), ",");
			Deque<Integer> deque = new LinkedList<>();
			// 생성한 덱에 일단 전부 삽입한다.
			for (int i = 0; i < n; i++) {
				deque.offer(Integer.parseInt(st.nextToken()));
			}

			boolean flag = true; // true : 순방향, false : 역방향
			boolean isError = false;

			// 함수 수행 for문 시작
			for (int i = 0; i < p.length(); i++) {
				// 뒤집기
				if (p.charAt(i) == 'R') {
					flag = !flag;
				}
				// 버리기
				else {
					// 만약 덱이 비어있다면?
					if (deque.isEmpty()) {
						sb.append("error").append("\n");
						isError = true;
						break;
					}

					// flag 방향을 보고 맨 앞을 판단한다.
					if (flag) {
						deque.pollFirst();
					} else {
						deque.pollLast();
					}
				}
			} // 함수 수행 for문 끝

			// 출력
			if (!isError) {
				sb.append("[");
				while (!deque.isEmpty()) {
					if (flag) {
						sb.append(deque.pollFirst());
					} else {
						sb.append(deque.pollLast());
					}

					if (!deque.isEmpty()) {
						sb.append(",");
					}
				}
				sb.append("]").append("\n");
			}
		} // 테케 끝

		System.out.print(sb);
	}
}
