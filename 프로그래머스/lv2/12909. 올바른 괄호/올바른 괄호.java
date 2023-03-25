import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            // 여는 괄호일 때
            if(s.charAt(i) == '(') {
                // 푸쉬한다.
                stack.push(s.charAt(i));
            }
            // 닫는 괄호일 때
            else {
                // 스택이 비어있다? 올바르지 않은 괄호이다.
                if(stack.isEmpty()) {
                    answer = false;
                    break;
                }
                else {
                    // top 을 확인한다.
                    char tmp = stack.peek();
                    // System.out.println(tmp);

                    // 그 top이 여는 괄호이면 짝이 되니까
                    // pop 한다.
                    if(tmp == '(') {
                        stack.pop();
                    }
                }
            }
        }
        
        // 다 끝났는데 스택에 여는 괄호가 남아있다? 올바르지 않은 괄호이다.
        if(!stack.isEmpty()) {
            answer = false;
        }

        return answer;
    }
}