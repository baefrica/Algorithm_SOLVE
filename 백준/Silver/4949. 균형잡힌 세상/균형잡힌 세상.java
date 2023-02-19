import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		// 소괄호와 대괄호 2종류
		/*
		 * 1. 서로 짝을 이루어야한다. 2. 일대일 매칭만 가능 3. 짝을 이루는 두 괄호가 있을 때, 그 사이에 있는 문자열도 균형이 잡혀야
		 * 한다.
		 */
		Scanner sc = new Scanner(System.in);

		while (true) {
			Stack<Character> stack = new Stack<>();
			String str = sc.nextLine();
			// 종료조건
			if (str.equals(".")) {
				break;
			}

			boolean isFinished = false;
			for (int i = 0; i < str.length(); i++) {
				char tmp;
				if (str.charAt(i) == '(' || str.charAt(i) == '[') {
					stack.push(str.charAt(i));
				} else if (str.charAt(i) == ')') {
					if (stack.isEmpty()) {
						System.out.println("no");
						isFinished = true;
						break;
					} else {
						tmp = stack.pop();
						if (tmp == '(') {
							continue;
						} else {
							System.out.println("no");
							isFinished = true;
							break;
						}
					}
				} else if (str.charAt(i) == ']') {
					if (stack.isEmpty()) {
						System.out.println("no");
						isFinished = true;
						break;
					} else {
						tmp = stack.pop();
						if (tmp == '[') {
							continue;
						} else {
							System.out.println("no");
							isFinished = true;
							break;
						}
					}
				}
			}

			// for문을 다 돌았을 때..
			if (!isFinished) {
				if (stack.isEmpty()) {
					System.out.println("yes");
				} else {
					System.out.println("no");
				}
			}
		} // while 문 끝
	}
}
