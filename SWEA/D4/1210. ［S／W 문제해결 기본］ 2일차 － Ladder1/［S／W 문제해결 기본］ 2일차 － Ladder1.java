import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int t = 1; t <= 10; t++) {
			int tc = sc.nextInt();
			int[][] data = new int[100][100];
			int cIdx = 0;
			
			// 배열 입력 받는 for문
			for(int i = 0; i < 100; i++) {
				for(int j = 0; j < 100; j++) {
					data[i][j] = sc.nextInt();
					
					// 정답을 받을 인덱스값
					if(data[i][j] == 2) {
						cIdx = j;
					}
				}
			}	// 배열 입력 받는 for문
			
			// 올라가면서 좌우탐색
			int[] dc = {-1, 1};
			int ans = 0;
			int nc = 0;
			
			for(int i = 99; i >= 0; i--) {
				for(int d = 0; d < 2; d++) {
					// 좌우 탐색을 해주는 탐색기
					nc = cIdx + dc[d];
					
					// 좌우 0이나 100을 넘어갈 때
					if(nc < 0 || nc > 99) {
						continue;
					}
					// 좌우가 0일때는 넘김
					if(data[i][nc] == 0) {
						continue;
					}
					
					// 계속 1나올 때 로직
					while(data[i][nc] == 1) {
						nc += dc[d];
						cIdx += dc[d];
						
						// 좌우 0이나 100을 넘어갈 때
						if(nc < 0 || nc > 99) {
							break;
						}
						// 좌우가 0일때는 넘김
						if(data[i][nc] == 0) {
							break;
						}
					}
					break;
				}
				if(i == 0) {
					ans = cIdx;
				}
			}
			System.out.println("#" + tc + " " + ans);
		}
	}
}