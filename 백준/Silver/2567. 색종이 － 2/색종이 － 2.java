import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 도화지 배열 생성
		int[][] arr = new int[102][102];
		int N = sc.nextInt();
		int[][] c = new int[N][2];
		
		// 색종이 입력받기
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < 2; j++) {
				c[i][j] = sc.nextInt();
			}
		}
		
		// 색종이칸에 1 더하기
		for(int i = 0; i < N; i++) {
			for(int m = c[i][0]+1; m < (c[i][0] + 11); m++) {
				for(int k = c[i][1]+1; k < (c[i][1] + 11); k++) {
					arr[m][k] = 1;
				}
			}
		}
		
		// 1인 칸을 찾고 상하좌우에 0이 있을 때마다 카운팅
		int cnt = 0;
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		int nr, nc;
		
		for(int r = 1; r < 101; r++) {
			for(int co = 1; co < 101; co++) {
				if(arr[r][co] == 1) {
					for(int d = 0; d < 4; d++) {
						nr = r + dr[d];
						nc = co + dc[d];
						
						if(arr[nr][nc] == 0) {
							cnt++;
						}
					}
				}
			}
		}
		System.out.println(cnt);
		
		// 배열 찍어보기
//		for(int i = 0; i < arr.length; i++) {
//			System.out.println(Arrays.toString(arr[i]));
//		}
	}
}