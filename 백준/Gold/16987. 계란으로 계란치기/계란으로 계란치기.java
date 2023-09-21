import java.util.Scanner;

public class Main {
	static int N;
	static int[][] egg;
	static int answer;

	public static void solution(int idx, int cnt) {
		// 가장 오른쪽 계란을 들었다면
		// 계란을 치고 종료기 때문에.. N-1이 아니라 N이다!
		if (idx == N) {
			// 최대 갯수 구하기
			answer = Math.max(answer, cnt);

			return;
		}
		// 들었는데 깨져있으면
		// 다음으로 넘어가자
		if (egg[idx][0] <= 0) {
			solution(idx + 1, cnt);

			return;
		}
		// 든 계란말고 나머지 계란이 모두 깨졌다면
		// 더이상 깰 계란이 없다 -> 다음으로 넘어가자
		if (cnt == N - 1) {
			solution(idx + 1, cnt);

			return;
		}

		for (int i = 0; i < N; i++) {
			// cnt도 되돌려줘야하기 때문에..
			int tmp = cnt;

			// 자기자신은 패스
			if (idx == i) {
				continue;
			}
			// 깨려고 하는 계란이 깨져있으면 패스
			if (egg[i][0] <= 0) {
				continue;
			}

			// idx 번 계란으로 i 번 계란을 친다.
			egg[idx][0] -= egg[i][1];
			// 깨졌으면 카운팅
			if (egg[idx][0] <= 0) {
				cnt++;
			}
			egg[i][0] -= egg[idx][1];
			// 깨졌으면 카운팅
			if (egg[i][0] <= 0) {
				cnt++;
			}

			solution(idx + 1, cnt);

			// dfs 니까 다시 되돌려놓는다.
			egg[idx][0] += egg[i][1];
			egg[i][0] += egg[idx][1];
			cnt = tmp;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		egg = new int[N][2];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 2; j++) {
				egg[i][j] = sc.nextInt();
			}
		}

		solution(0, 0);

		System.out.println(answer);
	}
}
