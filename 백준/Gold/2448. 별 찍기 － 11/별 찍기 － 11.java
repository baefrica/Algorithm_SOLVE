import java.util.Scanner;

public class Main {
	static int N;
	static char[][] map;

	// 재귀함수
	public static void func(int r, int c, int size) {
		// 기저 조건
		if (size == 3) {
			// 첫째줄
			map[r][c] = '*';

			// 둘째줄
			for (int j = c - 1; j <= c + 1; j += 2) {
				map[r + 1][j] = '*';
			}

			// 셋째줄
			for (int j = c - 2; j <= c + 2; j++) {
				map[r + 2][j] = '*';
			}

			return;
		}

		// 3분할
		func(r, c, size / 2);
		func(r + (size / 2), c - (size / 2), size / 2);
		func(r + (size / 2), c + (size / 2), size / 2);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 입력
		N = sc.nextInt();
		// 2차원 배열로 생성
		map = new char[N][2 * N - 1];

		// 재귀함수 실행
		func(0, (2 * N - 1) / 2, N); // 맨 위 꼭짓점

		// 출력
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if (map[i][j] != '*') {
					sb.append(" ");
				} else {
					sb.append(map[i][j]);
				}
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}
}
