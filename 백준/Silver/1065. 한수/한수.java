import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		// 100 보다 작다면 전부다 한수이다
		if(N < 100) {
			System.out.println(N);
		}
		// 세자리 수라면 한수 찾기
		else {
			int cnt = 99;
			for(int i = 100; i <= N; i++) {
				String str = Integer.toString(i);
				
				int m = str.charAt(0) - str.charAt(1);
				int n = str.charAt(1) - str.charAt(2);
				
				// 각 자리가 등차수열을 이룬다면
				if(m == n) {
					cnt++;
				}
			}
			System.out.println(cnt);
		}
	}
}