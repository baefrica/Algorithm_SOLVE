import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#" + t + " ");
			
			// 숫자판 입력 받는다
			int[][] arr = new int[9][9];
			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 9; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			Loop :
			while(true) {
				// 가로 탐색
				for(int i = 0; i < 9; i++) {
					int[] cnt = new int[10];
					
					for(int j = 0; j < 9; j++) {
						cnt[arr[i][j]]++;
					}
					for(int k = 1; k <= 9; k++) {
						if(cnt[k] == 0) {
							sb.append(0);
							break Loop;
						}
					}
				}	// 가로 끝
				
				// 세로 탐색
				for(int j = 0; j < 9; j++) {
					int[] cnt = new int[10];
					
					for(int i = 0; i < 9; i++) {
						cnt[arr[i][j]]++;
					}
					for(int k = 1; k <= 9; k++) {
						if(cnt[k] == 0) {
							sb.append(0);
							break Loop;
						}
					}
				}	// 세로 끝
				
				// 정사각형 탐색
				int idx = 0;
				int jdx = 0;
				
				while(true) {
					// 숫자 9 개를 우선 카운팅
					int[] cnt = new int[10];
					for(int i = idx; i < (idx + 3); i++) {
						for(int j = jdx; j < (jdx + 3); j++) {
							cnt[arr[i][j]]++;
						}
					}
					
					for(int k = 1; k <= 9; k++) {
						if(cnt[k] != 1) {
							sb.append(0);
							break Loop;
						}
					}
					
					// 다음 박스 탐색으로 넘어가게 하기 위해
					jdx+=3;
					// 열 끝까지 오면 행을 넘긴다
					if(jdx == 9) {
						jdx = 0;
						idx+=3;
					}
					// 행도 완전히 끝까지 오면 스도쿠 완성 했다는 의미로 1 출력
					if(idx == 9) {
						sb.append(1);
						break Loop;
					}
				}	// 정사각형 끝
			}	// 완전 전체 while 문
			
			System.out.println(sb);
		}
	}
}