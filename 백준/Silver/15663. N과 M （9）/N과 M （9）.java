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

		int prev = 0;
		for (int i = 0; i < arr.length; i++) {
			if (visited[i]) {
				continue;
			}

			// 같은 수가 나오면 넘어가자
			if (prev == arr[i]) {
				continue;
			}

			answer[idx] = arr[i];
			// prev를 바꿔준다.
			prev = arr[i];
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
