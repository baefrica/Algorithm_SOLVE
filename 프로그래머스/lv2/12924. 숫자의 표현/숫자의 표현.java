class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for(int i = 1; i <= n; i++) {
            int sum = i;
            for(int j = i+1; j <= n+1; j++) {
                if(sum < n) {
                    sum += j;
                    continue;
                }
                else if(sum == n) {
                    answer++;
                    break;
                }
                else {
                    break;
                }
            }
        }
        return answer;
    }
}