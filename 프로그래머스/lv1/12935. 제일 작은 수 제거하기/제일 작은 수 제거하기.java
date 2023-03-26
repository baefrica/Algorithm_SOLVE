import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        // answer 배열 길이
        int leng = 0;
        
        // answer 배열 생성
        if(arr.length == 1) {
            leng = 1;
        }
        else {
            leng = arr.length - 1;
        }
        int[] answer = new int[leng];
        
        if(leng != 1) {
            // 최솟값 저장
            int min = Integer.MAX_VALUE;
            for(int i = 0; i < arr.length; i++) {
                min = Math.min(arr[i], min);
            }

            int answerIdx = 0;
            for(int i = 0; i < arr.length; i++) {
                // 어짜피 한번밖에 실행안됨
                if(arr[i] == min) {
                    continue;
                }
                else {
                    answer[answerIdx] = arr[i];
                    answerIdx++;
                }
            }
        }
        else {
            answer[0] = -1;
        }
        
        return answer;
    }
}