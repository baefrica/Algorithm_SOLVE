import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[9];
		int max = Integer.MIN_VALUE;
		// 몇 번째 수인지 기억할 변수
		int idx = 0;
		for(int i = 0; i < 9; i++) {
			arr[i] = sc.nextInt();
			
			// 입력 받은 수가 최댓값이면
			if(arr[i] > max) {
				max = arr[i];
				// 배열의 인덱스는 0부터 시작하지만 그것이 첫 번째 값이므로 +1 해주기
				idx = (i + 1);
			}
		}
		
		System.out.printf("%d\n%d", max, idx);
	}
}