import java.util.Scanner;

public class Main {
	static int[][] map;
	static int[] cnt = new int[3];

	public static void func(int r, int c, int size) {
		// 시작점
		int tmp = map[r][c];
		boolean flag = true;

		// 기저 조건
		if (size == 1) {
			cnt[tmp + 1]++;
			return;
		}

		// 같은 색종이인가? 판별
		Loop: for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				if (map[i][j] != tmp) {
					flag = false;
					break Loop;
				}
			}
		}

		// 같은 색종이 일 때
		if (flag) {
			cnt[tmp + 1]++;
		}
		// 종이 9개로 나누자
		else {
			func(r, c, size / 3);
			func(r, c + (size / 3), size / 3);
			func(r, c + 2 * (size / 3), size / 3);

			func(r + (size / 3), c, size / 3);
			func(r + (size / 3), c + (size / 3), size / 3);
			func(r + (size / 3), c + 2 * (size / 3), size / 3);

			func(r + 2 * (size / 3), c, size / 3);
			func(r + 2 * (size / 3), c + (size / 3), size / 3);
			func(r + 2 * (size / 3), c + 2 * (size / 3), size / 3);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		// 재귀 함수 돌리기
		func(0, 0, N);

		// 출력
		for (int c : cnt) {
			System.out.println(c);
		}
	}
}
