class Solution {
    public String solution(String s) {
        String answer = "";
        
        // 짝수라면 가운데 두글자 반환
        if(s.length() % 2 == 0) {
            answer += s.substring(s.length() / 2 - 1, s.length() / 2 + 1);
        }
        else {
            answer += s.charAt(s.length() / 2);
        }
        return answer;
    }
}