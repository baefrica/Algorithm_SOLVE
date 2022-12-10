import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int sum = 0;
		
		// N 개의 줄에 입력받는다.
		for(int i = 0; i < N; i++) {
			int[] arr = new int[3];
			
			
			// 3개의 주사위 눈 입력받는다.
			for(int j = 0; j < 3; j++) {
				arr[j] = sc.nextInt();
			}
			
			// 같은 눈이 3개가 나오면
			if(arr[0] == arr[1] && arr[1] == arr[2]) {
				sum = Math.max(10000 + (arr[0] * 1000), sum);
			}
			
			// 같은 눈이 2개가 나오면
			if(arr[0] == arr[1] && arr[1] != arr[2]) {
				sum = Math.max(1000 + (arr[0] * 100), sum);
			}
			if(arr[0] == arr[2] && arr[1] != arr[2]) {
				sum = Math.max(1000 + (arr[0] * 100), sum);
			}
			if(arr[1] == arr[2] && arr[0] != arr[1]) {
				sum = Math.max(1000 + (arr[1] * 100), sum);
			}
			
			// 모두 다른 눈이 나오면
			if(arr[0] != arr[1] && arr[1] != arr[2] && arr[0] != arr[2]) {
				sum = Math.max(Math.max(arr[0], Math.max(arr[1], arr[2])) * 100, sum);
			}
		}
		
		System.out.println(sum);
	}
}

//# input : 
//3
//3 3 6
//2 2 2
//6 2 5
