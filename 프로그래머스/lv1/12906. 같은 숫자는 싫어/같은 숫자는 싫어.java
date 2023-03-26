import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < arr.length; i++) {
            // 비었을 때는 바로 넣기
            if(stack.isEmpty()) {
                stack.push(arr[i]);
            }
            // 안비었으면
            else {
                // 연속된 숫자면 continue
                if(stack.peek() == arr[i]) {
                    continue;
                }
                // 다른 숫자면 스택에 넣기
                else {
                    stack.push(arr[i]);
                }
            }
        }   // for문 끝
        
        // answer 에 담기
        // 스택에서 하나씩 빼면서
        // stack 은 top 에서 빼니까 배열은 뒤부터 채운다.
        int[] answer = new int[stack.size()];
        for(int i = answer.length-1; i >= 0; i--) {
            answer[i] = stack.pop();
        }
        
        return answer;
    }
}