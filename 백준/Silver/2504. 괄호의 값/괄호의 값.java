import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();

		Stack<Character> stack = new Stack<>();
		boolean isError = false;
		// 중간중간에 저장될 숫자
		int num = 1;
		// 최종 답
		int res = 0;

		Loop: for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);

			switch (c) {
			case '(':
				stack.push(c);
				// 괄호의 시작이므로
				num *= 2;
				break;

			case '[':
				stack.push(c);
				// 괄호의 시작이므로
				num *= 3;
				break;

			case ')':
				// 올바르지 못한 괄호열인 경우
				if (stack.isEmpty() || stack.peek() != '(') {
					isError = true;
					break Loop;
				}

				// 쌍을 이루는 괄호를 제거
				stack.pop();

				// 이전 괄호를 확인하고 최종 결과값에 더해준다.
				if (str.charAt(i - 1) == '(') {
					res += num;
				}
				// 다시 num 값을 2로 나눠준다.
				num /= 2;

				break;

			case ']':
				// 올바르지 못한 괄호열인 경우
				if (stack.isEmpty() || stack.peek() != '[') {
					isError = true;
					break Loop;
				}

				// 쌍을 이루는 괄호를 제거
				stack.pop();

				// 이전 괄호를 확인하고 최종 결과값에 더해준다.
				if (str.charAt(i - 1) == '[') {
					res += num;
				}
				// 다시 num 값을 3으로 나눠준다.
				num /= 3;

				break;
			}
		}

		// 마지막에 스택이 비었는지 확인을 해야한다!!
		if (!stack.isEmpty()) {
			isError = true;
		}

		// 출력
		if (isError) {
			System.out.println(0);
		} else {
			System.out.println(res);
		}
	}
}