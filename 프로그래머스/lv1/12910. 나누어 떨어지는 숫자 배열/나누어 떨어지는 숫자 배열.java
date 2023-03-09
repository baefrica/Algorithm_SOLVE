import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int cnt = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] % divisor == 0) {
                cnt++;
            }
        }
        
        int[] answer;
        if(cnt==0) {
            answer = new int[1];
            answer[0] = -1;
        }
        else {
            answer = new int[cnt];
        }
        
        int idx = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] % divisor == 0) {
                answer[idx++] = arr[i];
            }
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
}