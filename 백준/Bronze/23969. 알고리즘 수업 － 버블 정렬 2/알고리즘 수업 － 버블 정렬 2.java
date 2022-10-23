import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();	// 배열 A 의 크기
		int K = sc.nextInt();	// 교환 횟수
		
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		int tmp;
		int k = 0;
		// 버블정렬
		Loop :
		for(int i = (N - 1); i >= 0; i--) {
			for(int j = 0; j < i; j++) {
				// 둘의 위치를 바꿔주고 교환횟수+1
				if(arr[j] > arr[j+1]) {
					tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
					k++;
					
					// 교환횟수 일치하면
					if(k == K) {
						for(int n : arr) {
							System.out.print(n + " ");
						}
						break Loop;
					}
				}
			}
		}
		
		if(k < K) {
			System.out.println(-1);
		}
	}

}
