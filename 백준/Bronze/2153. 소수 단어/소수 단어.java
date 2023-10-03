import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String str = sc.next();

		int sum = 0;
		for (int i = 0; i < str.length(); i++) {
			int num = str.charAt(i) - 'a' + 1;

			if (num < 0) {
				num += 58;
			}

			// 합을 구한다.
			sum += num;
		}

		// 소수 판별 (여기서는 1도 소수라고 함)
		boolean prime = true;
		for (int i = 2; i < sum; i++) {
			if (sum % i == 0) {
				System.out.println("It is not a prime word.");
				prime = false;

				break;
			}
		}

		if (prime) {
			System.out.println("It is a prime word.");
		}
	}
}
