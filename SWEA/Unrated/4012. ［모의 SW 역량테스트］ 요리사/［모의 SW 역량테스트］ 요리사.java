//import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int N;
	static int[][] S;	// 시너지
	static int[] A;	// A 식재료
	static int[] B;		// B 식재료
	static boolean[] visited;	// 담긴거 체크
	static int[] sel = new int[2];	// 시너지 만들거 뽑기
	static int si = 0;
	static int sj = 0;
	static int sum = 0;	// 도구로 쓰다가 B 시너지 합
	static int sumA = 0;	// A 시너지 합
	static int min;	// 차이의 최소
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			N = sc.nextInt();
			S = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					S[i][j] = sc.nextInt();
				}
			}
			
			A = new int[N / 2];
			B = new int[N / 2];
			
			min = Integer.MAX_VALUE;
			
			divide(1, 0);
			System.out.println("#" + t + " " + min);
		}
	}
	
	// 식재료 나누는 함수
	public static void divide(int idx, int sidx) {
		// 절반 갯수 채우면
		if(sidx == N/2) {
			// 담긴 재료 체크해서 true 로 표시
			visited = new boolean[N+1];
			for(int i = 0; i < A.length; i++) {
				visited[A[i]] = true;
			}
			
			int jdx = 0;	// B에 넣을 때 인덱스값
			
			// 안담긴거는 false 이므로 그것들을 B에 넣어줌
			for(int i = 1; i < visited.length; i++) {
				if(visited[i] == false) {
					B[jdx] = i;
					jdx++;
				}
			}
			
			// 절반 크기의 식재료 조합을 구했으면 시너지를 찾아야지
			
//			System.out.println("A:    " + Arrays.toString(A));
			synergy(A, 0, 0);
			int sumA = sum;	// A 시너지의 합을 구한다
			
            sum = 0;	// sum 을 리셋
            
//			System.out.println("B:    " + Arrays.toString(B));
            synergy(B, 0, 0);		// B 시너지의 합을 구한다
            
            // 두 시너의 합의 차이의 최솟값을 구한다 -> 이게 최종 출력 목표
            min = Math.min(Math.abs(sumA - sum), min);
            sum = 0;	// 다음 식재료 조합으로 가기 위해 sum 을 리셋

			return;
		}
		
		// 끝까지 검사했으면
		if(idx == N+1) {
			return;
		}
		
		// 조합
		A[sidx] = idx;
		divide(idx+1, sidx+1);
		divide(idx+1, sidx);
	}
	
	// 두개씩 뽑아서 시너지 만들 함수
	public static void synergy(int[] array, int idx, int sidx) {
		// 두개씩 뽑아서 시너지 이차원 배열 찾아가서 합까지 구한다
		if(sidx == 2) {
			si = S[sel[0]-1][sel[1]-1];
			sj = S[sel[1]-1][sel[0]-1];
			sum += si + sj;	// 시너지의 합
			return;
		}
		
		if(idx == N/2) {
			return;
		}
		
		// 조합
		sel[sidx] = array[idx];
		synergy(array, idx+1, sidx+1);
		synergy(array, idx+1, sidx);
	}
}