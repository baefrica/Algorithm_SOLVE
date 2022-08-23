import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			int[][] arr = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			int cnt = 0;
			int ans = 0;
			
			// 가로로 탐색
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(arr[i][j] == 1) {
						cnt++;
					}
					else {
						if(cnt == K) {							
							ans++;
						}
						cnt = 0;
					}
				}
				// 벽에 왔는데 1이야, 근데 갯수가 딱맞을 때
				if(cnt == K) {
					ans++;
				}
				cnt = 0;
			}
			
			// 세로로 탐색
			for(int j = 0; j < N; j++) {
				for(int i = 0; i < N; i++) {
					if(arr[i][j] == 1) {
						cnt++;
					}
					else {
						if(cnt == K) {							
							ans++;
						}
						cnt = 0;
					}
				}
				// 벽에 왔는데 1이야, 근데 갯수가 딱맞을 때
				if(cnt == K) {					
					ans++;
				}
				cnt = 0;
			}
			System.out.println("#" + tc + " " + ans);
						
		}	// 전체 for문
	}
}