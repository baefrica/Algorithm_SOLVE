class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        int pCnt = 0;
        int yCnt = 0;
        
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'p' || s.charAt(i) == 'P') {
                pCnt++;
            }
            if(s.charAt(i) == 'y' || s.charAt(i) == 'Y') {
                yCnt++;
            }
        }
        
        if(pCnt != yCnt) {
            answer = false;
        }
        
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return answer;
    }
}