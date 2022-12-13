import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N;
	static int[] arr;
	
	// binarySearch
	public static int binarySearch(int n) {
		boolean flag = false;		// 카드 있는지 없는지 판별용
		int st = 0;						// 이분탐색 범위의 시작점
		int ed = (N - 1);				// 이분탐색 범위의 끝점
		
		while(st <= ed) {
			int mid = ( (st + ed) / 2 );
			
			if(n < arr[mid]) {
				ed = (mid - 1);
			}
			// 찾았다 -> 종료
			else if (n == arr[mid]) {
				flag = true;
				break;
			}
			else {
				st = (mid + 1);
			}
		}
		
		if(flag) {
			return 1;
		}
		else {
			return 0;
		}
	}
	
	// main
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();		// 숫자 카드의 갯수
		arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		// arr 배열을 오름차순 정렬
		Arrays.sort(arr);
		
		int M = sc.nextInt();
		for(int i = 0; i < M; i++) {
			int m = sc.nextInt();
			// 카드를 가지고 있으면 1, 아니면 0을 출력
			
			System.out.print(binarySearch(m) + " ");
		}
	}
}