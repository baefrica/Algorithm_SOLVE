import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[N];
		int max = Integer.MIN_VALUE;
		
		// 주어진 약수들 중 최댓값을 구한다
		for(int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
			max = Math.max(max, arr[i]);
		}
		
		// 주어진 약수 중 최댓값 다음부터 시작
		max++;
		
		// 이제 정답을 찾자
		int ans = max;
		
		// 계속 실행
		boolean flag = true;
		while(flag) {
			// 첨으로 돌아오면 1 증가
			ans++;
			// 배열에 있는 수들 검사
			for(int i = 0; i < arr.length; i++) {
				// 약수가 아닐 경우 첨으로 돌아가자
				if(ans % arr[i] != 0) {
					break;
				}	// if 문
				// 배열 속 모든 수가 다 약수일 경우
				if(i == (arr.length - 1)) {
					// 홀수 제곱수인 경우 고려
					int cnt = 0;
					// 구한 ans 값의 약수 갯수 세기
					for(int c = 1; c <= ans; c++) {
						if(ans % c == 0) {
							cnt++;
						}
					}
					// 그 갯수가 맞으면 멈추고 정답으로 출력
					if(cnt == (N + 2)) {
						System.out.println(ans);
						flag = false;
					}	// 아니면 첨으로 돌아가야해
				}	// if 문
			}	// for 문
		}	// while 문
	}
}