import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int cnt = n;
		// 규칙을 찾았다
		// n 이 최대 10000
		for(int k = 2; k <= 100; k++) {
			if(n / k <= 1) {
				break;
			}
			
			// 제곱수가 되는 순간 그 수의 정사각형부터 쌓아간다
			if((n / k) >= k) {
				cnt += ((n / k) - k + 1);
			}
		}
		
		System.out.println(cnt);
	}
}