import java.util.Arrays;
import java.util.Scanner;

public class Main {
	// idx 0 : -4000
	// idx 4000 : 0
	// idx 8000 : 4000
	static int[] cntArr = new int[8001];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();		// N 은 홀수

		int[] arr = new int[N];
		int maxCnt = Integer.MIN_VALUE;
		int sum = 0;
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
			
			cntArr[arr[i]+4000]++;
			maxCnt = Math.max(maxCnt, cntArr[arr[i]+4000]);
			sum += arr[i];
		}
		// 산술평균 출력
		System.out.println(Math.round((double)sum / N));
		
		// 중앙값 출력
		Arrays.sort(arr);
		System.out.println(arr[N / 2]);
		
		// 최빈값 출력
		int count = 0;	// 최빈값이 몇개인지
		int mode = Integer.MAX_VALUE;
		for(int i = 0; i < 8001; i++) {
			if(cntArr[i] == maxCnt) {
				count++;
				mode = (i - 4000);
			}
			// 최빈값이 2개가 되면 바로 그 수 출력하고 종료
			if(count == 2) {
				System.out.println(i - 4000);
				break;
			}
		}
		// 최빈값이 하나면
		if(count == 1) {
			System.out.println(mode);
		}
		
		// 범위 출력
		System.out.println(arr[N-1] - arr[0]);
	}
}