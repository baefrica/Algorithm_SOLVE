import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static StringBuilder sb;
	static int N;
	static int M;
	static int[] arr;
	static boolean[] visited;
	static int[] ans;

	public static void func(int idx, int cnt) {
		// 기저조건
		if (cnt == M) {
			// 출력을 위한 과정
			for (int i : ans) {
				sb.append(i).append(" ");
			}
			sb.append("\n");

			return;
		}

		for (int i = 0; i < arr.length; i++) {
			// true면 패스
			if (visited[i]) {
				continue;
			}
			
			// ans에 삽입
			ans[idx] = arr[i];
			// 방문 표시
			visited[i] = true;
			
			func(idx + 1, cnt + 1);
			
			// 방문 풀기
			visited[i] = false;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();

		N = sc.nextInt();
		M = sc.nextInt();

		// 숫자 배열을 입력받고 오름차순 정렬하기
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);

		visited = new boolean[N];

		// 정답을 저장할 배열
		ans = new int[M];
		
		// 백트래킹 함수 실행
		func(0, 0);
		
		// 출력
		System.out.print(sb);
	}
}
