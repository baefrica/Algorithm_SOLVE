import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String S = sc.next();										// 입력 받는다
			
		Stack<Character> stack = new Stack<>();		// 스택 생성
		// 괄호검사 시작
		int cnt = 0;
		for(int i = 0; i < S.length(); i++) {
			// 왼쪽 괄호인 경우 push
			if( S.charAt(i) == '(' ) {
				stack.push(S.charAt(i));
			}
			// 오른쪽 괄호인 경우 일단 pop
			else {
				// 스택이 비어있다?
				if( stack.isEmpty() ) {
					cnt++;
				}
				// 비어있지 않다 -> pop
				else {
					stack.pop();
				}
			}
		}	// 괄호검사 끝
		
		// 괄호검사 후 스택에 남아있는 만큼 괄호 필요함
		cnt += stack.size();
		System.out.println(cnt);
	}
}
