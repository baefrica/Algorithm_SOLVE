class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        int res = 0;
        int tmp = x;
        while(tmp != 0) {
            res += (tmp % 10);
            tmp /= 10;
        }
        if(x % res != 0) {
            answer = false;
        }
        
        return answer;
    }
}