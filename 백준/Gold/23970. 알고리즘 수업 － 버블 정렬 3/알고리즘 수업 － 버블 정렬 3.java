import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();	// 배열 A, B 의 크기
		
		int[] A = new int[N];
		int[] B = new int[N];
		for(int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}
		for(int i = 0; i < N; i++) {
			B[i] = sc.nextInt();
		}
		
		int checkCnt = 0;
		// 버블정렬
		for(int i = (N - 1); i >= 0; i--) {
			// 자리가 잡혀있으면 swap 하지말고 넘어가
			if(A[i] == B[i]) {
//				System.out.println(Arrays.toString(A));
//				System.out.println("체크2");
				checkCnt++;
				continue;
			}
			for(int j = 0; j < i; j++) {
				int tmp;
				// 둘의 위치를 바꿔준다
				if(A[j] > A[j+1]) {
					tmp = A[j];
					A[j] = A[j+1];
					A[j+1] = tmp;
				}
				
				// 맨 뒤부터 맞추면 다음단계로 넘어감
//				System.out.println(Arrays.toString(A));
				if(A[i] == B[i]) {
//					System.out.println("체크");
					checkCnt++;
					break;
				}
			}
		}
		
		if(checkCnt == N) {
			System.out.println(1);
		}
		else {
			System.out.println(0);
		}
	}
}