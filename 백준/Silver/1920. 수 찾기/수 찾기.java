import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N;
	static int[] A;
	
	// binarySearch
	public static void binarySearch(int n) {
		boolean flag = false;		// 존재하는지 안하는지 판별용
		int st = 0;						// 이분탐색 범위의 시작점
		int ed = (N - 1);				// 이분탐색 범위의 끝점
		
		while(st <= ed) {
			int mid = ( (st + ed) / 2 );
			
			if(n < A[mid]) {
				ed = (mid - 1);
			}
			// 찾았다 -> 종료
			else if (n == A[mid]) {
				flag = true;
				break;
			}
			else {
				st = (mid + 1);
			}
		}
		
		if(flag) {
			System.out.println(1);
		}
		else {
			System.out.println(0);
		}
	}
	
	// main
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		A = new int[N];
		for(int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}
		// A 배열을 오름차순 정렬
		Arrays.sort(A);
		
		int M = sc.nextInt();
		for(int i = 0; i < M; i++) {
			int m = sc.nextInt();
			// 존재하면 1, 존재하지 않으면 0을 출력
			binarySearch(m);
		}
	}
}