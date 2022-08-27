import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc = 1; tc <= 10; tc++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#" + tc + " ");
			
			// 100 X 100 크기의 2차원 배열 생성
			int N = sc.nextInt();
			int[][] magnetic = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					magnetic[i][j] = sc.nextInt();
				}
			}
			
			int cnt = 0;
			int nr = 0;
			int nc = 0;
			
			for(int j = 0; j < N; j++) {
				for(int i = 0; i < N; i++) {
					// N극이라면 아래로 움직인다
					if(magnetic[i][j] == 1){
						nr = i; nc = j;
						
						while(true) {
							// 경계를 넘어가지 않도록 하기 위해
							if(nr == (N - 1)) {
								break;
							}
							
							// S극을 만나면
							if(magnetic[++nr][nc] == 2) {
								cnt++;
								i = nr;
								break;
							}
						}	// while문 끝
					}	// N극
				}
			}
			
			sb.append(cnt);
			System.out.println(sb);
		}
	}
}