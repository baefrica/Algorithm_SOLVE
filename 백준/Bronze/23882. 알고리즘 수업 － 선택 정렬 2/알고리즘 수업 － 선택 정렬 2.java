import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();			// 배열 A 의 크기
		int K = sc.nextInt();			// 교환 횟수 K
		
		int[] A = new int[N];
		for(int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}
		
		int cnt = 0;
		for(int i = (N - 1); i > 0; i--) {
			int max = Integer.MIN_VALUE;		// 최댓값 담을 거야
			int maxIdx = -1;								// 한 싸이클에서 최댓값인 값 인덱스
			
			for(int j = 0; j <= i; j++) {
				if(max < A[j]) {
					max = A[j];
					maxIdx = j;
				}
			}
			// 가장 큰 숫자가 그 자리에 없다면
			// 교환 작업
			if(maxIdx != i) {
				cnt++;
				
				int tmp = A[i];
				A[i] = A[maxIdx];
				A[maxIdx] = tmp;
			}
			
			if(cnt == K) {
				for(int j = 0; j < N; j++) {
					System.out.print(A[j] + " ");
				}
				break;
			}

		}	// 제일 큰 for문 끝
		
		// 교환 횟수가 K 보다 작으면 -1을 출력
		if(cnt < K) {
			System.out.println(-1);
		}
	}
}