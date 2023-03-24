class Solution {
    public long solution(int price, int money, int count) {
        long answer = 0;
        
        int idx = 1;
        while(idx <= count) {
            answer += (price * idx);
            idx++;
        }
        
        if(answer > money) {
            answer = answer - money;
        }
        else {
            answer = 0;
        }
        
        return answer;
    }
}