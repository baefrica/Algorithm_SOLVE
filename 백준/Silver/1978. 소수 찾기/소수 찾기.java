import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int ans = 0;
		
		for(int i = 0; i < N; i++) {
			int n = sc.nextInt();
			int cnt = 0;
			
			for(int j = 1; j <= n; j++) {
				// 약수이면 카운팅
				if(n % j == 0) {
					cnt++;
				}
			}
			
			// 주어진 수들 중 소수의 개수 센다 (약수의 갯수가 2개인 것만)
			if(cnt == 2) {
				ans++;
			}
		}
		
		System.out.print(ans);
	}
}