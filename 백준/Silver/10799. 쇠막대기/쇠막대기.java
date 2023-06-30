import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		Stack<Character> stack = new Stack<>();
		int curr = 0;
		int cnt = 0;
		for (int i = 0; i < str.length(); i++) {
			switch (str.charAt(i)) {
			case '(':
				// 삽입한다.
				stack.push('(');

				// 그 다음꺼까지 봐야한다!!
				// 이 판단으로 레이저인지, 시작하는 조각인지를 판단해야할 것 같다.
				// 레이저라면 그냥 넘어가면 된다.
				if (str.charAt(i + 1) == '(') {
					curr++;
				}

				break;

			case ')':
				// 레이저를 쏜 것이므로 현재 가지고 있는 막대기수만큼 조각에 더해준다.
				if (stack.peek() == '(') {
					cnt += curr;
				}
				// 잘려나간 조각수 +1
				// 현재 막대기수를 -1
				else {
					cnt++;
					curr--;
				}
				
				// 삽입한다.
				stack.push(')');

				break;
			}
		}
		
		// 조각 수 출력
		System.out.println(cnt);
	}
}
