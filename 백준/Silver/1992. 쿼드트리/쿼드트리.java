import java.util.Scanner;

public class Main {
	static char[][] map;
	static StringBuilder sb = new StringBuilder();

	public static void func(int r, int c, int size) {
		// 기저 조건
		if (size == 1) {
			sb.append(map[r][c]);
			return;
		}

		// 시작점
		char tmp = map[r][c];
		// 쿼드트리로 압축가능한가?
		boolean isTree = true;

		Loop: for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				if (map[i][j] != tmp) {
					isTree = false;
					break Loop;
				}
			}
		}

		// 압축되었다
		if (isTree) {
			sb.append(tmp);
		}
		// 분할하자
		else {
			sb.append("(");
			// 1사분면
			func(r, c, size / 2);
			// 2사분면
			func(r, c + (size / 2), size / 2);
			// 4사분면
			func(r + (size / 2), c, size / 2);
			// 3사분면
			func(r + (size / 2), c + (size / 2), size / 2);
			sb.append(")");
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 1 ≤ N ≤ 64
		map = new char[N][N];

		for (int i = 0; i < N; i++) {
			String line = sc.next();
			for (int j = 0; j < N; j++) {
				map[i][j] = line.charAt(j);
			}
		}

		// 재귀 함수 돌리기
		func(0, 0, N);

		System.out.println(sb);
	}
}
