import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[10];
		for(int i = 0; i < 10; i++) {
			arr[i] = sc.nextInt();
		}
		
		int sum = 0;	// 100 넘었을 때 합
		int idx = 0;	// 합이 100 넘었을 때 인덱스 값
		for(idx = 0; idx < 10; idx++) {
			sum += arr[idx];
			
			// 100 넘으면 멈춰
			if(sum > 100) {
				break;
			}
		}
		
		int sum2 = 0;		// 100 안넘었을 때 합
		for(int i = 0; i < idx; i++) {
			sum2 += arr[i];
		}
		// 100 보다 작게 젤 가까운 것과의 차이
		int m = 100 - sum2;
		// 100 보다 크게 젤 가까운 것과의 차이
		int n = sum - 100;
		
		if(m >= n) {
			System.out.println(sum);
		}
		else {
			System.out.println(sum2);
		}
	}
}