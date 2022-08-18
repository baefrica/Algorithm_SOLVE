import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 테스트 케이스 갯수
		int TC = sc.nextInt();
		
		for(int tc = 1; tc <= TC; tc++) {
			int k = sc.nextInt();
			Stack<Integer> stack = new Stack<>();
			
			for(int i = 0; i < k; i++) {
				int n = sc.nextInt();
				
				// 입력받은 수가 0이 아닐 때와 0일 때로 나누어 생각하기
				if(n != 0) {
					stack.push(n);
				}
				else {
					stack.pop();
				}
			}
			
			int ans = 0;
			// 남아있는 원소들의 합
			for(int i = 0; i < stack.size(); i++) {
				ans += stack.get(i);
			}
			System.out.println("#" + tc + " " + ans);
		}
	}
}