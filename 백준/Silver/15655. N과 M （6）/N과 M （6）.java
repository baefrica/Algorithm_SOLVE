import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int M;
	static int[] arr;
	static boolean[] visited;
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

//		System.out.println("idx : " + idx);
//		System.out.println("cnt : " + cnt);
//		System.out.println(Arrays.toString(answer));

		for (int i = 0; i < arr.length; i++) {
			if (visited[i]) {
				continue;
			}

			// 1. 모두 다른 수이다.
			// 2. 오름차순이어야 한다.
			if (idx > 0 && answer[idx - 1] >= arr[i]) {
//				System.out.println("continue!");
				continue;
			}

			answer[idx] = arr[i];
			visited[i] = true;
			func(idx + 1, cnt + 1);
			visited[i] = false;
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

		visited = new boolean[N];
		answer = new int[M];

		func(0, 0);
		System.out.print(sb);
	}
}
