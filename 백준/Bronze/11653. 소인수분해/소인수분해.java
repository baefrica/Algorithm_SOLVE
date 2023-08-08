import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		boolean[] check = new boolean[N + 1];
		int tmp = N;
		for (int i = 2; i <= N; i++) {
			if (check[i]) {
				continue;
			}
			while (tmp % i == 0) {
				tmp /= i;
				System.out.println(i);
			}
			if (tmp == 1) {
				break;
			}

			for (int j = i; j <= N; j += i) {
				if (check[j]) {
					continue;
				}

				check[j] = true;
			}
		}
	}
}
