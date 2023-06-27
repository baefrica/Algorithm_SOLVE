import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// 입력 받는다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // (1 ≤ N ≤ 1,000,000)

		// 숫자 배열
		int[] Arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < Arr.length; i++) {
			Arr[i] = Integer.parseInt(st.nextToken());
		}

		// 정답을 저장할 배열
		int[] res = new int[N];
		// 스택 생성
		Stack<Integer> stack = new Stack<>();

		for (int i = N - 1; i >= 0; i--) {
			// 현재 값
			int curr = Arr[i];

			// 맨 마지막은 항상 결과값이 -1
			if (stack.isEmpty()) {
				res[i] = -1;
				stack.push(curr);
			}
			// 두번째부터는...
			else {
				while (true) {
					// pop() 을 계속 하다가 빈 스택이 될 경우
					if (stack.isEmpty()) {
						// -1 출력하고 종료
						res[i] = -1;
						// *** 한 번 틀려서 예외 테케를 찾아서 추가한 코드!! ***
						stack.push(curr);
						break;
					}

					// 현재 값 < 스택의 top
					if (curr < stack.peek()) {
						// 결과값을 뽑아내고
						res[i] = stack.peek();
						// 스택에 push 함으로써 top 을 바꿔줌
						stack.push(curr);
						break;
					}
					// 현재 값 >= 스택의 top
					else {
						// top 제거 후 계속 진행...
						// 여기서 왜 top 을 제거해도 상관이 없는 지 생각해보는 것이 중요할 것 같다!!
						stack.pop();
						continue;
					}
				}
			}
		} // for문 끝 : O(N)

		// 출력
		StringBuilder sb = new StringBuilder();
		for (int i : res) {
			sb.append(i).append(" ");
		}
		System.out.println(sb);
	}
}