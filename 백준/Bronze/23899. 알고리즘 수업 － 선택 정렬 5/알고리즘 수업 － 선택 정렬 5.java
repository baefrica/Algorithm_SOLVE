import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[] A;
	static int[] B;
	static boolean flag = false;
	
	// A 배열 swap
	public static void swap(int a, int b) {
		int tmp = A[a];
		A[a] = A[b];
		A[b] = tmp;
	}
	
	// main
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();			// 배열 A, B 의 크기
		
		A = new int[N];
		for(int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}
		
		B = new int[N];
		for(int i = 0; i < N; i++) {
			B[i] = sc.nextInt();
		}
		
		for(int i = (N - 1); i >= 0; i--) {
			int max = Integer.MIN_VALUE;		// 최댓값 담을 거야
			int maxIdx = -1;								// 한 싸이클에서 최댓값인 값 인덱스
			
			// 초기 상태 배열도 정렬 과정에서 발생 가능한 경우로 생각하자 !!
			// B 배열과 같은 지 체크하기
			flag = false;
			for(int j = 0; j < N; j++) {
				if(A[j] == B[j]) {
					flag = true;		// 같으면 true 로 바꿔주고 다음으로 바로 넘기기
					continue;
				}
				else {
					flag = false;		// 다르면 false 로 바꿔주고 바로 체크 그만
					break;
				}
			}
			
			// 체크 다 끝나고 flag 가 true 이면 1 출력 후 종료
			if(flag) {
				System.out.println(1);
				break;
			}
			
			for(int j = 0; j <= i; j++) {
				if(max < A[j]) {
					max = A[j];
					maxIdx = j;
				}
			}
			
			// 가장 큰 숫자가 그 자리에 없다면 교환한다
			if(maxIdx != i) {
				// 교환 작업
//				int tmp = A[i];
//				A[i] = A[maxIdx];
//				A[maxIdx] = tmp;
				swap(i, maxIdx);
				
			}	// 교환하는 if 문 끝
			
			
		}	// 제일 큰 for문 끝
		
		if(!flag) {
			System.out.println(0);
		}
	}
}