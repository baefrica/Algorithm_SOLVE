import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int M;
	static int[] arr;
	static int[] answer;
	static StringBuilder sb;

	public static void func(int idx, int cnt) {
		// 기저 조건
		if (cnt == M) {
			for (int i : answer) {
				sb.append(i + " ");
			}
			sb.append("\n");

			return;
		}

		for (int i = 0; i < arr.length; i++) {
			// 고른 수열이 비내림차순이어야 한다.
			if (idx > 0 && answer[idx - 1] > arr[i]) {
				continue;
			}

			answer[idx] = arr[i];
			func(idx + 1, cnt + 1);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();

		int N = sc.nextInt();
		M = sc.nextInt();

		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);

		answer = new int[M];

		func(0, 0);
		System.out.print(sb);
	}
}
