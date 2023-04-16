import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static int[] arr;
	static boolean[] visited;
	static int[] result;

	static void perm(int idx) {
		if (idx == M) {
			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < M; i++) {
				sb.append(result[i]).append(" ");
			}
			System.out.println(sb);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (visited[i]) {
				continue;
			}

			result[idx] = arr[i];
			visited[i] = true;
			perm(idx + 1);
			visited[i] = false;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		visited = new boolean[N];
		result = new int[M];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		// 오름차순 정렬
		Arrays.sort(arr);

		perm(0);
	}
}
