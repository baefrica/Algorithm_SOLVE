import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#" + tc + " ");
			
			int N = sc.nextInt();
			int[][] arr = new int[N+2][N+2];
			// 디폴트 값
			arr[N/2][N/2] = arr[N/2+1][N/2+1] = 2;
			arr[N/2][N/2+1] = arr[N/2+1][N/2] = 1;
			
			// 돌을 놓는 횟수
			int M = sc.nextInt();
			
			int[] dr = {-1, -1, -1, 0, 1, 1, 1, 0};
			int[] dc = {-1, 0, 1, 1, 1, 0, -1, -1};
			int nr, nc;
			
			for(int i = 0; i < M; i++) {
				int col = sc.nextInt();
				int row = sc.nextInt();
				// 1 이면 흑돌, 2 이면 백돌
				int type = sc.nextInt();
				
				// 흑돌을 놓을 때
				if(type == 1) {
					arr[row][col] = 1;
					
					// 8 방 탐색을 한다
					for(int d = 0; d < 8; d++) {
						int k = 1;
						
						nr = row + (k * dr[d]);
						nc = col + (k * dc[d]);
						
						// 옆에 백돌이 있다면 while 반복문 시작
						if(arr[nr][nc] == 2) {
							boolean flag = true;
							
							while (flag) {
								k++;
								nr = row + (k * dr[d]);
								nc = col + (k * dc[d]);
								
								// 다시 흑돌을 만났으면
								if(arr[nr][nc] == 1) {
									// 돌아온 길을 다 흑돌로 바꾼다
									while(k > 1) {
										k--;
										nr = row + (k * dr[d]);
										nc = col + (k * dc[d]);
										
										arr[nr][nc] = 1;
									}
									flag = false;
								}
								// 벽을 만났을 때 멈춰
								else if(arr[nr][nc] == 0) {
									flag = false;
								}
								// 백돌이 나왔을 때 계속 ㄱㄱ
								else {
									continue;
								}
							} // while 문 끝
						}
					}
				} // 흑돌 놓을 때 끝
				
				// 백돌을 놓을 때
				else {
					arr[row][col] = 2;
					
					// 8 방 탐색을 한다
					for(int d = 0; d < 8; d++) {
						int k = 1;
						
						nr = row + (k * dr[d]);
						nc = col + (k * dc[d]);
						
						// 옆에 흑돌이 있다면 while 반복문 시작
						if(arr[nr][nc] == 1) {
							boolean flag = true;
							
							while (flag) {
								k++;
								nr = row + (k * dr[d]);
								nc = col + (k * dc[d]);
								
								// 다시 백돌을 만났으면
								if(arr[nr][nc] == 2) {
									// 돌아온 길을 다 백돌로 바꾼다
									while(k > 1) {
										k--;
										nr = row + (k * dr[d]);
										nc = col + (k * dc[d]);
										
										arr[nr][nc] = 2;
									}
									flag = false;
								}
								// 벽을 만났을 때 멈춰
								else if(arr[nr][nc] == 0) {
									flag = false;
								}
								// 흑돌이 나왔을 땐 계속 ㄱㄱ
								else {
									continue;
								}
							} // while 문 끝
						}
					}
				}
			}
			
			// 갯수 세기
			int black = 0;
			int white = 0;
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {
					if(arr[i][j] == 1) {
						black++;
					}
					if(arr[i][j] == 2){
						white++;
					}
				}
			}
			
			sb.append(black + " " + white);
			System.out.println(sb);
		} // 테스트케이스 for문
	}
}