import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		// 인접 행렬 만들기
		int[][] adjArr = new int[N+1][N+1];
		
		// 간선을 입력 받는다 -> 인접 행렬이 완성됨
		for(int i = 0; i < M; i++) {
			int st = sc.nextInt();
			int ed = sc.nextInt();
			
			adjArr[st][ed] = 1;
			adjArr[ed][st] = 1;
		}
		
//		for(int i = 0; i < N+1; i++) {
//			System.out.println(Arrays.toString(adjArr[i]));
//		}
		
		// 친구 수를 세서 -> 출력
		for(int i = 1; i <= N; i++) {
			int cnt = 0;
			for(int j = 1; j <= N; j++) {
				if(adjArr[i][j] == 1) {
					cnt++;
				}
			}
			System.out.println(cnt);
		}
	}
}