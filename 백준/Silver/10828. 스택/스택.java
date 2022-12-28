import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<>();
		
		int N = Integer.parseInt(br.readLine());		// 명령의 수
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			// push
			if(st.countTokens() == 2) {
				String tmp = st.nextToken();
				
				stack.push( Integer.parseInt(st.nextToken()) );
			}
			// pop or size or empty or top
			else {
				String tmp = st.nextToken();
				
				// pop
				if( tmp.equals("pop") ) {
					if( !stack.isEmpty() ) {
						System.out.println( stack.pop() );
					}
					else {
						System.out.println(-1);
					}
				}				
				// size
				else if( tmp.equals("size") ) {
					System.out.println( stack.size() );
				}
				// empty
				else if( tmp.equals("empty") ) {
					if( stack.isEmpty() ) {
						System.out.println(1);
					}
					else {
						System.out.println(0);
					}
				}
				// top
				else {
					if( !stack.isEmpty() ) {
						System.out.println( stack.peek() );
					}
					else {
						System.out.println(-1);
					}
				}
			}
		}
	}
}