import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();

		StringTokenizer st = new StringTokenizer(str, ":");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// n이 더 크냐? m이 더 크냐?
		int big = Math.max(n, m);
		int small = Math.min(n, m);

		// small의 약수 모두 체크
		boolean[] check = new boolean[small + 1];
		for (int i = 1; i <= small; i++) {
			if (small % i == 0) {
				check[i] = true;
			}
		}

		// 최대 공약수 찾기
		int tmp = 0;
		for (int i = check.length - 1; i >= 1; i--) {
			// 최대 공약수를 찾았다.
			if (check[i] && big % i == 0) {
				tmp = i;
				break;
			}
		}

		// 출력
		System.out.println((n / tmp) + ":" + (m / tmp));
	}
}