class Solution {
    public int solution(int num) {
        int answer = 0;
        long tmp = num;
        
        // 주어진 수가 1인 경우에는 0
        if(tmp == 1) {
            answer = 0;
        }
        
        while(tmp != 1) {
            // 작업을 500번 반복할 때까지 1이 되지 않는다면 –1을 반환
            if(answer == 500) {
                answer = -1;
                break;
            }
            
            if(tmp % 2 == 0) {
                tmp /= 2;
            }
            else {
                tmp = (tmp * 3) + 1;
            }
            // 작업을 몇 번이나 반복해야 하는지 반환
            answer++;
        }
        return answer;
    }
}