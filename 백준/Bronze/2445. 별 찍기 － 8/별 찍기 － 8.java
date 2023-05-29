import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		for (int i = 1; i <= N; i++) {
			// 왼쪽 별
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			// 가운데 공백
			for (int j = 0; j < 2 * (N - i); j++) {
				System.out.print(" ");
			}
			// 오른쪽 별
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		for (int i = 1; i < N; i++) {
			// 왼쪽 별
			for (int j = 0; j < (N - i); j++) {
				System.out.print("*");
			}
			// 가운데 공백
			for (int j = 0; j < (2 * i); j++) {
				System.out.print(" ");
			}
			// 오른쪽 별
			for (int j = 0; j < (N - i); j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
