import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 에라토스테네스의 체
		int R = 123456 * 2;
		boolean[] check = new boolean[R + 1];
		for (int i = 2; i <= R; i++) {
			if (check[i]) {
				continue;
			}

			for (int j = i * 2; j <= R; j += i) {
				if (check[j]) {
					continue;
				}

				check[j] = true;
			}
		}

		while (true) {
			int n = sc.nextInt();

			// 종료 조건
			if (n == 0) {
				break;
			}

			// n 보다 크고, 2n 보다 작거나 같은 소수의 갯수 구하기
			int cnt = 0;
			for (int i = n + 1; i <= n * 2; i++) {
				if (!check[i]) {
					cnt++;
				}
			}

			// 출력
			System.out.println(cnt);
		}
	}
}
