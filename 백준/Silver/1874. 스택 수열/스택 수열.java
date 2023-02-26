import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		// 스택 세팅
		Stack<Integer> stack = new Stack<>();

		int n = sc.nextInt();
		int idx = 1;
		boolean flag = true;

		for (int i = 0; i < n; i++) {
			int num = sc.nextInt();

			while (true) {
				if (stack.isEmpty() || stack.peek() != num) {
					// 스택에 집어넣기
					stack.push(idx);
//					System.out.println("집어넣은 idx : " + idx);
					sb.append("+").append("\n");
					idx++;
				}

				if (stack.peek() > num) {
					flag = false;
					break;
				}

				// 찾았다
				if (stack.peek() == num) {
					stack.pop();
					sb.append("-").append("\n");
					break;
				}
			} // while문 끝
		}

		if (flag) {
			System.out.print(sb);
		} else {
			System.out.println("NO");
		}
	}
}
