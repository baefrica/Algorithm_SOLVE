import java.util.Scanner;

public class Main {
	static int N;
	// 출력 때문에 배열을 생성할 수 밖에 없다..
	static char[][] map;

	// 재귀함수
	public static void func(int r, int c, int size) {
		// 기저 조건
		if (size == 3) {
			// 별 채우기!!
			for (int i = r; i < r + 3; i++) {
				for (int j = c; j < c + 3; j++) {
					// 가운데 blank
					if (i == r + 1 && j == c + 1) {
						map[i][j] = ' ';
						continue;
					}
					// 나머지는 별
					map[i][j] = '*';
				}
			}

			return;
		} else {
			// 9분할 했을 때..
			// 윗줄
			func(r, c, size / 3);
			func(r, c + (size / 3), size / 3);
			func(r, c + 2 * (size / 3), size / 3);

			// 중간줄
			func(r + (size / 3), c, size / 3);
//			func(r + (size / 3), c + (size / 3), size / 3);
			func(r + (size / 3), c + 2 * (size / 3), size / 3);

			// 아랫줄
			func(r + 2 * (size / 3), c, size / 3);
			func(r + 2 * (size / 3), c + (size / 3), size / 3);
			func(r + 2 * (size / 3), c + 2 * (size / 3), size / 3);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new char[N][N];

		// 처음에 모두 공백으로 세팅 -> char 배열을 처음에 초기화했을 때 공백이 아니다.
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = ' ';
			}
		}

		// 재귀함수 실행
		func(0, 0, N);
		
		// 출력
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
