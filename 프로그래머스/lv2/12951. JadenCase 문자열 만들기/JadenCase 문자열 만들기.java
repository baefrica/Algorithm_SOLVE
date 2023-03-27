class Solution {
    public String solution(String s) {
        String answer = "";
        
        // 반복문 돌린다.
        // 두개 배웠다.
        // 1. char 형을 문자열로 바꿀 때 : String.valueOf(' ')
        // 2. 소문자를 대문자로 : toUpperCase(), 대문자를 소문자로 : toLowerCase()
        for(int i = 0; i < s.length(); i++) {
            if(i == 0 || s.charAt(i-1) == ' ') {
                answer += String.valueOf(s.charAt(i)).toUpperCase();
            }
            else {
                answer += String.valueOf(s.charAt(i)).toLowerCase();
            }
        }
        
        return answer;
    }
}