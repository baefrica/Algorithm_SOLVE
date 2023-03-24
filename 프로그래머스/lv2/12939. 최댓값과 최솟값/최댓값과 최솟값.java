import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        int cnt = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' ') {
                cnt++;
            }
        }
        
        int[] arr = new int[cnt+1];
        
        String tmp = "";
        int arrIdx = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != ' ') {
                tmp += s.charAt(i);
                
                if(i == s.length()-1) {
                    arr[arrIdx] = Integer.parseInt(tmp);
                }
            }
            else {
                arr[arrIdx++] = Integer.parseInt(tmp);
                tmp = "";
            }
        }
        
        // 오름차순
        Arrays.sort(arr);
        
        answer = Integer.toString(arr[0]) + " " + Integer.toString(arr[cnt]);
        
        return answer;
    }
}