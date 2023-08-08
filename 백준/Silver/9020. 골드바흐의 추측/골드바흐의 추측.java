import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 소수의 합으로 이루어진 짝수 -> 골드바흐 파티션
		// 소수의 범위는 2이상
		// n의 범위는 4이상 10000이하

		// 에라토스테네스의 체
		boolean[] check = new boolean[9999];
		for (int i = 2; i < check.length; i++) {
			if (check[i]) {
				continue;
			}

			for (int j = i * 2; j < check.length; j += i) {
				if (check[i]) {
					continue;
				}

				check[j] = true;
			}
		}

		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int n = sc.nextInt();

			int res = Integer.MAX_VALUE;
			int x = 0;
			int y = 0;
			for (int i = 2; i <= (n / 2); i++) {
				// 소수가 아니면 패스
				if (check[i]) {
					continue;
				}

				// "n - 소수 = 소수"이면
				if (!check[n - i]) {
					if (res > (n - i) - i) {
						x = i;
						y = (n - i);
					}
				}
			}

			System.out.println(x + " " + y);
		}
	}
}
