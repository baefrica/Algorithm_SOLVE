import java.util.Scanner;

public class Main {
	static int N;
	static boolean[][] board;
	static int cnt;

	// 퀸을 놓을 수 있느냐
	static boolean isPossible(int r, int c) {
		int left = c;
		int right = c;

		for (int i = (r - 1); i >= 0; i--) {
			left--;
			right++;

			// 왼쪽 대각위, 위, 오른쪽 대각위 탐색
			if (board[i][c]) {
				return false;
			}
			if (left >= 0 && board[i][left]) {
				return false;
			}
			if (right < N && board[i][right]) {
				return false;
			}
		}
		// 위 조건이 다 안맞다면 가능하다~
		return true;
	}

	// 퀸 놓기
	static void putQueen(int r) {
		// 기저조건
		if (r == N) {
			cnt++;
			return;
		}

		// 퀸을 놓을 수 있는 지 검사하기
		for (int c = 0; c < N; c++) {
			if (isPossible(r, c)) {
				board[r][c] = true;
				putQueen(r + 1);
				board[r][c] = false;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		board = new boolean[N][N];
		cnt = 0;

		// 0행부터 퀸을 놓자
		putQueen(0);
		System.out.println(cnt);
	}
}
