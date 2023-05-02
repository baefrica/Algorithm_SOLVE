class Solution {
    public String solution(String s, int n) {
        // 17 ~ 42
        char[] big = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        // 49 ~ 74
        char[] small = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        
        String answer = "";
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < s.length(); i++) {
            int tmp = s.charAt(i) - '0';
            
            if(tmp < 0) {
                sb.append(" ");
            }
            else if(tmp <= 42) {
                if(tmp-17+n >= 26) {
                    sb.append(big[tmp-17+n-26]);
                }
                else {
                    sb.append(big[tmp-17+n]);
                }
            }
            else {
                if(tmp-49+n >= 26) {
                    sb.append(small[tmp-49+n-26]);
                }
                else {
                    sb.append(small[tmp-49+n]);
                }
            }
        }
        
        answer += sb;
        
        return answer;
    }
}