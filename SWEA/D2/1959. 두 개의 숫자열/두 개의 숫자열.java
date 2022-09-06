import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			// A B 배열로 수들 입력받기
			int[] A = new int[N];
			for(int i = 0; i < A.length; i++) {
				A[i] = sc.nextInt();
			}
			int[] B = new int[M];
			for(int i = 0; i < B.length; i++) {
				B[i] = sc.nextInt();
			}
			
			// 작은 수열을 한 칸씩 뒤로 밀려고 만든 k
			int k = 0;
			// 곱의 합들 중 최댓값
			int maxAns = Integer.MIN_VALUE;
			
			// 첫번째 수열이 작을 경우			
			if(Math.min(N, M) == N) {
				// 작은 수열의 마지막 인덱스 값이
				int lastIdx = (N - 1);
				
				// 목표에 도달하게 되면 그까지만 하고 멈추게 한다
				while(lastIdx < M) {
					int sum = 0;
					// 한세트 곱들 해서 더한 값
					for(int i = 0; i < N; i++) {
						for(int j = (i + k); j <= (i + k); j++) {
							sum += (A[i] * B[j]);
						}
					}
					// sum 이 나올 때마다 최댓값 판별
					if(maxAns < sum) {
						maxAns = sum;
					}
					k++;
					lastIdx++;
				}	// while 문 끝
			}	// if 문 끝
			// 두번째 수열이 작을 경우
			else {
				int lastIdx = (M - 1);
				
				while(lastIdx < N) {
					int sum = 0;
					// 한세트 곱들 해서 더한 값
					for(int i = 0; i < M; i++) {
						for(int j = (i + k); j <= (i + k); j++) {
							sum += (A[j] * B[i]);
						}
					}
					// sum 이 나올 때마다 최댓값 판별
					if(maxAns < sum) {
						maxAns = sum;
					}
					k++;
					lastIdx++;
				}	// while 문 끝
			}	// else 문 끝
			
			System.out.println("#" + t + " " + maxAns);
		}
	}
}