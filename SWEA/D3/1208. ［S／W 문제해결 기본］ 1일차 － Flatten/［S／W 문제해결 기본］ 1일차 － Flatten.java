import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 10번의 테스트케이스
		for(int tc = 1; tc <= 10; tc++) {
			int T = sc.nextInt();		// 덤프 횟수를 입력 받는다
			int d = 100;
			Integer[] arr = new Integer[d];
			
			// 100개의 입력값을 다 받는다
			for(int i = 0; i < d; i++) {
				arr[i] = sc.nextInt();
			}
			
			// 덤프 횟수만큼..
			for(int i = 0; i < T; i++) {
				Arrays.sort(arr, Collections.reverseOrder());	// 내림차순 정렬
				arr[0]--;	// 젤 높은 건 한칸씩 빼준다
				arr[d-1]++;		// 젤 낮은 건 한칸씩 더해준다
			}
			Arrays.sort(arr, Collections.reverseOrder());	// 덤프 다 끝나고 나서 한 번 더 내림차순 정렬 해줘야 한다!!!
			System.out.println("#" + tc + " " + (arr[0] - arr[d-1]));
		}
	}
}