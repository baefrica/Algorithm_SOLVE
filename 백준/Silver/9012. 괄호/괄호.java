import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 0; tc < T; tc++) {
			String PS = sc.next();									// 입력 받는다
			
			Stack<Character> stack = new Stack<>();		// 스택 생성
			boolean isValid = true;									// 올바른 괄호 문자열인가?
			
			// 1. 왼쪽 괄호는 를 만나면 push, 오른쪽 괄호를 만나면 pop
			// 2. 오른쪽 괄호와 짝이 맞는 지를 검사 -> 이 때, 스택이 비어 있으면 NO, 괄호의 짝이 맞지 않으면 NO
			// 3. 마지막 괄호까지 조사 후, 스택에 괄호가 남아 있으면 NO
			for(int i = 0; i < PS.length(); i++) {
				// 왼쪽 괄호인 경우
				if( PS.charAt(i) == '(' ) {
					stack.push(PS.charAt(i));
				}
				// 오른쪽 괄호인 경우
				else {
					if( stack.isEmpty() ) {
						System.out.println("NO");
						isValid = false;
						break;
					}
					if( stack.pop() != '(' ) {
						System.out.println("NO");
						isValid = false;
						break;
					};
				}
			}	// 괄호검사 끝
			
			// 위에서 안걸렸는데
			if(isValid) {
				// 스택이 비어있다면 깔끔하게 YES
				if( stack.isEmpty() ) {
					System.out.println("YES");
				}
				// 비어있지 않다면 NO
				else {
					System.out.println("NO");
				}
			}
		}
	}
}
