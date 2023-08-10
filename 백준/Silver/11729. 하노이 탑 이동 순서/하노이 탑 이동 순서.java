import java.util.Scanner;

public class Main {
	static int K;
	static StringBuilder sb;

	// 원판 n개를 a번 기둥에서 b번 기둥으로 옮기는 함수
	public static void func(int a, int b, int n) {
		K++;

		if (n == 1) {
			sb.append(a + " " + b).append("\n");
			return;
		}

//		다른 방법
//		if (n == 0) {
//			return;
//		} else {
//			K++;
//		}

		// (n-1)개 원판을 a, b가 아닌 다른 기둥으로 옮겨야 한다.
		func(a, 6 - a - b, n - 1);
		// n번 원판을 a에서 b로 옮긴다.
		sb.append(a + " " + b).append("\n");
		// (n-1)개 원판을 a, b가 아닌 다른 기둥에서 b로 옮겨야 한다.
		func(6 - a - b, b, n - 1);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		K = 0;
		sb = new StringBuilder();

		// 1번에서 3번으로 N개의 원판을 옮기기
		func(1, 3, N);

		System.out.println(K);
		System.out.println(sb);
	}
}
