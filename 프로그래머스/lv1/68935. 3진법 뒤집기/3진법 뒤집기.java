import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        Stack<Integer> stack = new Stack<>();
        while(true) {
            if(n < 3) {
                stack.push(n);
                break;
            }
            
            int tmp = (n % 3);
            n /= 3;
            stack.push(tmp);
            
            if(n < 3) {
                stack.push(n);
                break;
            }
        }   // while문 끝
        
        int idx = 0;
        while(!stack.isEmpty()) {
            answer += Math.pow(3, idx++) * stack.pop();
        }
        return answer;
    }
}