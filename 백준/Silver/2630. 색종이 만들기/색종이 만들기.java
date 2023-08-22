import java.util.Scanner;

public class Main {
	static int N;
	static int[][] map;
	static int white;
	static int blue;

	// 색깔 탐색 : 시작점 좌표와 크기를 매개변수로
	public static void checkColor(int r, int c, int size) {
//		System.out.println("check함수 " + r + ", " + c);

		// 시작점 색깔
		int color = map[r][c];
		boolean flag = true;

		// r과 c 범위, 시작점 실수하지 말자!! 유의하자!!
		Loop: for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				// 패스 조건
				if (i == r && j == c) {
					continue;
				}

				if (map[i][j] == color) {
//					System.out.println(i + " " + j);
					continue;
				}
				// 다른 색깔 찾았다.
				else {
					flag = false;
					func(r, c, size / 2);
					break Loop; // break 를 안해서 다음 for문이 계속 돌았다..
				}
			}
		}

		// 모두 같은 색으로 칠해져 있을 때 처리
		if (flag) {
			if (color == 0) {
				white++;
//				System.out.println("흰색 추가 " + white);
//				System.out.println();
			} else {
				blue++;
//				System.out.println("파랑 추가 " + blue);
//				System.out.println();
			}
		}
	}

	// 재귀 함수
	public static void func(int r, int c, int size) {
//		System.out.println("func 실행 " + "사이즈는 " + size);

		// 분할되어 있지 않은 처음 상황일 때
		if (size == N) {
			checkColor(r, c, size);
		} else {
			// 1사분면
//			System.out.println("1사분면 진입");
			checkColor(r, c, size);
			// 2사분면
//			System.out.println("2사분면 진입");
			checkColor(r, c + size, size);
			// 3사분면
//			System.out.println("3사분면 진입");
			checkColor(r + size, c + size, size);
			// 4사분면
//			System.out.println("4사분면 진입");
			checkColor(r + size, c, size);
		}
	}

	// main
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		func(0, 0, N);

		System.out.println(white);
		System.out.println(blue);
	}
}

// 1트 : Out of Index Error
// 2트 : 1456, 962
// 3트 : 147, 112
// 4트 : 154, 148
// 5트 : 8, 10
// 6트 : 9, 6
// 7트 : 테스트케이스는 맞지만 틀렸다..
// 1번째 반례 스스로 찾음 :
//4
//0 1 0 1
//0 1 0 0
//0 0 1 1
//0 1 1 0
// output :
//7
//6
// answer :
//9
//7
// 틀린 이유 : (r+1, c)부터 시작함 -> (r, c+1) 이 맞지..

// 8트 : 또 틀렸다..
// 2번째 반례 스스로 찾음 :
//2
//1 1
//0 1
// output :
//0
//1
// answer :
//1
//3
// 틀린 이유 : (r, c+1)부터 시작하면, 첫번째 열은 다 건너뛰어버리게 된다.. -> (r, c)로 시작점을 설정해야 한다.