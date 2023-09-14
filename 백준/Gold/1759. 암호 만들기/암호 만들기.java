import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb;
	static int L;
	static int C;
	static char[] arr;
	static boolean[] visited;
	static char[] answer;

	public static void dfs(int idx, int cnt) {
		if (cnt == L) {
			// 최소 한 개의 모음(a, e, i, o, u)과 최소 두 개의 자음으로 구성되어 있다.
			int CNT = 0;
			int noCNT = 0;
			for (char i : answer) {
				if (i == 'a' || i == 'e' || i == 'i' || i == 'o' || i == 'u') {
					CNT++;
				} else {
					noCNT++;
				}
			} // 확인 끝

			// 출력 준비
			if (CNT > 0 && noCNT > 1) {
				for (char i : answer) {
					sb.append(i);
				}
				sb.append("\n");
			}

			return;
		}

		for (int i = 0; i < arr.length; i++) {
			if (visited[i]) {
				continue;
			}

			if (idx > 0 && answer[idx - 1] > arr[i]) {
				continue;
			}

			answer[idx] = arr[i];
			visited[i] = true;
			dfs(idx + 1, cnt + 1);
			visited[i] = false;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();

		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		String str = br.readLine();
		arr = new char[C];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = str.charAt(i * 2);
		}
		Arrays.sort(arr);

		visited = new boolean[C];
		answer = new char[L];

		dfs(0, 0);

		System.out.print(sb);
	}
}
