class Solution {
    static int[] numbers;
    static int target;
    
    static int answer = 0;
    static boolean[] visited;
    static int sum = 0;
    
    public void DFS(int idx, int sum) {
        // 탈출 조건
        if(idx == numbers.length) {
            // target 넘버와 비교
            if(sum == target) {
                answer++;
            }
            
            return;
        }
        
        DFS(idx+1, sum + numbers[idx]);
        DFS(idx+1, sum - numbers[idx]);
    }
    
    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
        
        DFS(0, sum);
        
        return answer;
    }
}