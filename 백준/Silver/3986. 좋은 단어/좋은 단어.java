import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			Stack<Character> stack = new Stack<>();
			for (int j = 0; j < str.length(); j++) {
				char curr = str.charAt(j);

				// 비어있으면 새로운 문자 삽입
				if (stack.isEmpty()) {
					stack.push(curr);
				}
				// 비어있지 않을 때
				else {
					// top과 같다면 pop
					if (curr == stack.peek()) {
						stack.pop();
					}
					// 다르다면 push
					else {
						stack.push(curr);
					}
				}
			} // 문자열 탐색 끝

			// 탐색이 다 끝나고 스택확인
			if (stack.isEmpty()) {
				// 스택이 비어있다면 "좋은 단어"이므로 카운팅
				cnt++;
			}
		}

		System.out.println(cnt);
	}
}
