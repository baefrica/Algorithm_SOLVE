import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long n = sc.nextLong();

		long sum = 0;
		for (long i = 1; i < n - 1; i++) {
			sum += i * (i + 1);
		}

		long res = sum / 2;

		System.out.println(res);
		System.out.println(3);
	}
}
