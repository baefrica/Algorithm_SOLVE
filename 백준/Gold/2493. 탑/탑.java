import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// 스택에 탑의 해당 위치와 높이를 쌍으로 저장해야한다.
class Tower {
	int idx;
	int height;

	Tower(int idx, int height) {
		this.idx = idx;
		this.height = height;
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		// 입력받는다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		// StringBuilder
		StringBuilder sb = new StringBuilder();

		// 스택 생성
		Stack<Tower> stack = new Stack<>();

		// 반복문 실행
		for (int i = 0; i < N; i++) {
			int curr = Integer.parseInt(st.nextToken()); // 현재 높이

			// 앞에서부터 탐색한다...

			// 처음에 스택이 비어있다면 -> 0 출력, 스택에 현재 값 push
			if (stack.isEmpty()) {
				sb.append(0).append(" ");
				stack.push(new Tower(i + 1, curr));
			}
			// 스택이 비어있지 않다면
			else {
				while (true) {
					// 예외 잘 체크하자!! : 하나씩 제거하다가 빈 스택이 될 경우...
					if (stack.isEmpty()) {
						// 나보다 높은 탑이 없으므로 0 출력 후 종료
						sb.append(0).append(" ");
						stack.push(new Tower(i + 1, curr));
						break;
					}

					// 스택의 top 이 나보다 높다면 -> 바로 출력 후 현재 탑 push
					if (stack.peek().height > curr) {
						sb.append(stack.peek().idx).append(" ");
						stack.push(new Tower(i + 1, curr));
						break;
					}
					// 스택의 top 이 나보다 낮다면
					else {
						// top 은 어짜피 나보다 높이가 낮으니까 제거하면 된다.
						stack.pop();
						// 그리고 다음 꺼를 보러 간다.
						continue;
					}
				}
			}
		}

		// 출력
		System.out.println(sb);
	}
}