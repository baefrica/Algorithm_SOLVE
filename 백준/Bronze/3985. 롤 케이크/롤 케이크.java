import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt();
		int N = sc.nextInt();

		int expMax = 0;
		int maxIdx = 0;
		int[] cake = new int[L + 1];
		// 조각 갯수 저장
		int[] cnt = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			int P = sc.nextInt();
			int K = sc.nextInt();
			cnt[i] = K - P + 1;
			if (cnt[i] > expMax) {
				expMax = cnt[i];
				maxIdx = i;
			}

			for (int j = P; j <= K; j++) {
				if (cake[j] == 0) {
					cake[j] = i;
				} else {
					cnt[i]--;
				}
			}
		}

		int res = 0;
		int resNum = 0;
		for (int i = 1; i <= N; i++) {
			if (cnt[i] > res) {
				res = cnt[i];
				resNum = i;
			}
		}
		System.out.println(maxIdx);
		System.out.println(resNum);
	}
}
