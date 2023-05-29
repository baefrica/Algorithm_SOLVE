import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int[] arr = new int[20];
		for (int i = 0; i < 20; i++) {
			arr[i] = i + 1;
		}

		// 구간 10회 입력받는다.
		for (int i = 0; i < 10; i++) {
			int st = sc.nextInt();
			int ed = sc.nextInt();
			// 카드 바꾸는 횟수
			int cnt = (ed - st + 1) / 2;

			// 역배치 과정
			for (int j = 0; j < cnt; j++) {
				int tmp = arr[st - 1 + j];
				arr[st - 1 + j] = arr[ed - 1 - j];
				arr[ed - 1 - j] = tmp;
			}
		}

		// 출력
		for (int i = 0; i < 20; i++) {
			if (i != 19) {
				sb.append(arr[i]).append(" ");
			} else {
				sb.append(arr[i]);
			}
		}
		System.out.println(sb);

	}
}
