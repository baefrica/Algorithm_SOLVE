import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 1000 이하의 삼각수 배열
		int[] arr = new int[44];
		for(int i = 0; i < arr.length; i++) {
			for(int j = 1; j <= (i + 1); j++) {
				arr[i] += j;
			}
		}
		
		int T = sc.nextInt();
		for(int tc = 0; tc < T; tc++) {
			int num = sc.nextInt();
			boolean flag = false;		// 답을 찾았다, 못찾았다는 판별
			
			Loop :
			for(int i = 0; i < arr.length; i++) {
				for(int j = 0; j < arr.length; j++) {
					for(int k = 0; k < arr.length; k++) {
						// 삼각수 3개를 골라 더한 합
						int sum = ( arr[i] + arr[j] + arr[k] );
						
						// 삼각수의 합으로 표현할 수 있다면 1 출력
						if(sum == num) {
							System.out.println(1);
							flag = true;
							break Loop;
						}
					}
				}
			}
			
			// 그렇지 않다면 0 출력
			if(!flag) {
				System.out.println(0);
			}
		}	// 테케 끝
	}
}
