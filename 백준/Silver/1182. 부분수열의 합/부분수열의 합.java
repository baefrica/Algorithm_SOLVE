import java.util.Scanner;

public class Main {
	static int N;
	static int S;
	static int[] arr;
	static int CNT;

	public static void dfs(int depth, int sum) {
//		System.out.println("depth : " + depth + " sum : " + sum);

		// 기저 조건
		if (depth == N) {
			// 합이 S 와 같다면
			if (sum == S) {
				CNT++;
			}

			return;
		}

		// 1. 해당 depth의 숫자를 더했을 때
		dfs(depth + 1, sum + arr[depth]);
		// 2. 해당 depth의 숫자를 안 더했을 때
		dfs(depth + 1, sum);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 정수 갯수
		S = sc.nextInt(); // 정수
		arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		// 백트래킹
		dfs(0, 0);
		
		// S가 0일 때, 공집합 갯수 1개 뺴줘야한다.
		if(S == 0) {
			CNT--;
		}

		// 출력
		System.out.println(CNT);
	}
}
