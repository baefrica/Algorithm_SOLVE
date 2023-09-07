import java.util.*;

class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        
        // x^2 + y^2 = r^2 공식을 이용해야 한다..
        for(int x = 0; x < r1; x++) {
            // 각 x 좌표별로 cnt 구하기
            double y2 = Math.sqrt(Math.pow(r2, 2) - Math.pow(x, 2));
            double y1 = Math.sqrt(Math.pow(r1, 2) - Math.pow(x, 2));
            
            // 사이 갯수 세기
            int cnt = (int)Math.floor(y2) - (int)Math.ceil(y1) + 1;
            
            answer += cnt;
        }
        
        for(int x = r1; x < r2; x++) {
            // 각 x 좌표별로 cnt 구하기
            double y2 = Math.sqrt(Math.pow(r2, 2) - Math.pow(x, 2));
            
            // 사이 갯수 세기
            int cnt = (int)Math.floor(y2);

            answer += cnt;
        }
        
        // 4개의 사분면이 똑같은 갯수
        answer *= 4;
        
        return answer;
    }
}