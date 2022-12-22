import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		boolean[] check = new boolean[N+1];
		int cnt = 0;
		
		Loop :
		for(int i = 2; i <= N; i++) {
			// 넘기는 조건
			if(check[i]) {
				continue;
			}
			
			for(int j = i; j <= N; j += i) {
				// 넘기는 조건
				if(check[j]) {
					continue;
				}
				// 지웠다는 표시
				check[j] = true;
				cnt++;
				// K 번째 지워진 수 출력
				if(cnt == K) {
					System.out.println(j);
					break Loop;
				}
			}
		}
	}
}
