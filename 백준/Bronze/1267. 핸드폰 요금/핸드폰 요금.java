import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int N = sc.nextInt(); // 20이하 자연수

		int Y = 0; // 영식 요금제
		int M = 0; // 민식 요금제
		for (int i = 0; i < N; i++) {
			int cost = sc.nextInt();

			Y += ((cost / 30) + 1) * 10;
			M += ((cost / 60) + 1) * 15;
		}

		if (Y > M) {
			sb.append("M ").append(M);
		} else if (Y == M) {
			sb.append("Y M ").append(Y);
		} else {
			sb.append("Y ").append(Y);
		}

		System.out.println(sb);
	}
}
