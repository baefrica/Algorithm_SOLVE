import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 에라토스테네스의 체
		boolean[] check = new boolean[1000000];
		for (int i = 2; i < check.length; i++) {
			if (check[i]) {
				continue;
			}

			for (int j = i * 2; j < check.length; j += i) {
				if (check[j]) {
					continue;
				}

				check[j] = true;
			}
		}

		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int N = sc.nextInt();
			int cnt = 0;

			for (int i = 2; i <= N / 2; i++) {
				if (!check[i]) {
					int tmp = N - i;

					if (!check[tmp]) {
						cnt++;
					}
				}
			}

			System.out.println(cnt);
		}
	}
}
