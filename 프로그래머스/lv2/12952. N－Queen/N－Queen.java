class Solution {
    static int num;
    static boolean[][] visited;
    static int answer;
    
    // 퀸을 놓을 수 있냐 없냐
    static boolean isPossible(int r, int c) {
        int left = c;
        int right = c;
        
        for(int i = r-1; i >= 0; i--) {
            left--;
            right++;
            
            if(visited[i][c]) {
                return false;
            }
            if(left >= 0 && visited[i][left]) {
                return false;
            }
            if(right < num && visited[i][right]) {
                return false;
            }
        }
        
        return true;
    }
    
    static void backtracking(int r) {
        // 기저조건
        if(r == num) {
            answer++;
            return;
        }
        
        for(int i = 0; i < num; i++) {
            if(isPossible(r, i)) {
                visited[r][i] = true;
                backtracking(r+1);
                visited[r][i] = false;
            }
        }
    }
    
    public int solution(int n) {
        num = n;
        // 말판
        visited = new boolean[n][n];
        // 방법의 수
        answer = 0;
        
        backtracking(0);
        
        return answer;
    }
}