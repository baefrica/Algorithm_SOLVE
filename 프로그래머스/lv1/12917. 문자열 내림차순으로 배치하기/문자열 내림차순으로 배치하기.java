import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        
        char[] array = s.toCharArray();
        Arrays.sort(array);
        
        String answer = "";
        
        for(int i = 0; i < s.length(); i++) {
            // a - z : 97 - 122
            // A - Z : 65 - 90
            answer += array[s.length() - 1 - i];
        }
        
        return answer;
    }
}