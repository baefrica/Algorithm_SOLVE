import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int size = 10;
		int[] arr = new int[size];
		
		for(int t = 1; t <= T; t++) {
			for(int i = 0; i < size; i++) {
				arr[i] = sc.nextInt();	// 배열을 입력 받는다
			}
			
			int tmp = 0;
			
			// 배열을 오름차순으로 버블정렬
			for(int j = size - 1; j > 0; j--) {
				for(int i = 0; i < size - 1; i++) {
					if(arr[i] > arr[i+1]) {
						tmp = arr[i+1];
						arr[i+1] = arr[i];
						arr[i] = tmp;
					}
				}
			}
			
			int sum = 0;	// 합 초기화
			int cnt = 0;	// 평균을 구할 값들의 갯수
			
			// 중간값들을 더할 건데..
			for(int i = 1; i < size - 1; i++) {
				// min 값과 같거나 max 값과 같을 때는 빼줘야한다
				if(arr[i] != arr[0] && arr[i] != arr[size-1]) {
					sum += arr[i];
					cnt++;
				}
			}
			System.out.println("#" + t + " " + Math.round(((double)sum / cnt)));
		}
	}
}