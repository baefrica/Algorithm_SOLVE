import java.util.*;

// 그리디 문제라고 한다..
// 모두 요격할 수 있는 최소 미사일 수를 찾는 문제
// 개구간이 끝나는 지점을 확인하면서 미사일을 요격해나간다고 생각해야 한다..
class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        // 람다식을 활용하여 2차원 배열 정렬
        Arrays.sort(targets, (o1, o2) -> {
            // return o1[0]-o2[0]; // 첫번째 숫자 기준 오름차순
            // return o2[0]-o1[0]; // 첫번째 숫자 기준 내림차순
            return o1[1]-o2[1]; // 두번째 숫자 기준 오름차순
            // return o2[1]-o1[1]; // 두번째 숫자 기준 내림차순
        });
        
        // for(int i = 0; i < targets.length; i++) {
        //     System.out.println(Arrays.toString(targets[i]));
        // }
        
        // 시작 요격점
        int x = targets[0][1];
        answer++;
        
        for(int i = 1; i < targets.length; i++) {
            int next = targets[i][0];
            
            // next 도 같이 요격 가능
            if(x > next) {
                continue;
            }
            // next 요격 불가능
            // 요격점이 바뀔 때
            else {
                x = targets[i][1];
                // 미사일 수 추가
                answer++;
            }
        }
        
        return answer;
    }
}

// 1차 채점 결과 : 27.3