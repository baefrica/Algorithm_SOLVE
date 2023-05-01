import java.util.*;

class Solution {
    static int[] d;
    static int budget;
    static int maxCnt = 0;
    
    public void dfs(int idx, int sum, int cnt) {
        // 추가 : 배열 끝까지 가면 종료
        // 예산보다 같거나 클 때
        if(sum >= budget || idx == d.length) {
            // 예산 넘었을 때는 cnt--
            if(sum > budget) {
                cnt--;
            }
            
            maxCnt = Math.max(maxCnt, cnt);
            return;
        }
        
        dfs(idx+1, sum + d[idx], cnt+1);
    }
    
    public int solution(int[] d, int budget) {
        this.d = d;
        this.budget = budget;
        
        int answer = 0;
        
        // 오름차순 정렬
        Arrays.sort(d);
        
        int sum = 0;
        dfs(0, sum, 0);
        
        answer = maxCnt;
        
        return answer;
    }
}