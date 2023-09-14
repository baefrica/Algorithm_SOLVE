import java.util.Scanner;

public class Main {
	static StringBuilder sb;
	static int k;
	static int[] S;
	static boolean[] visited;
	static int[] answer;

	public static void dfs(int idx, int cnt) {
		if (cnt == 6) {
			for (int i : answer) {
				sb.append(i).append(" ");
			}
			sb.append("\n");

			return;
		}

		for (int i = 0; i < k; i++) {
			if (visited[i]) {
				continue;
			}

			// 오름차순이어야 한다 (수열의 순서만 바뀐다면 같은 수열임)
			if (idx > 0 && answer[idx - 1] > S[i]) {
				continue;
			}

			answer[idx] = S[i];
			visited[i] = true;
			dfs(idx + 1, cnt + 1);
			visited[i] = false;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			sb = new StringBuilder();

			k = sc.nextInt();

			// 테스트케이스 종료
			if (k == 0) {
				break;
			}

			S = new int[k];
			for (int i = 0; i < k; i++) {
				S[i] = sc.nextInt();
			}

			visited = new boolean[k];
			answer = new int[6];

			dfs(0, 0);

			System.out.println(sb);
		}
	}
}
