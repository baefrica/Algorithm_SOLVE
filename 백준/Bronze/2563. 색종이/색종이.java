import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 도화지 배열 생성
		int[][] arr = new int[100][100];
		int N = sc.nextInt();
		int[][] c = new int[N][2];
		
		// 색종이 입력받기
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < 2; j++) {
				c[i][j] = sc.nextInt();
			}
		}
		
		// 칸수 색칠
		for(int i =0; i < N; i++) {
			for(int m = c[i][0]; m < (c[i][0] + 10); m++) {
				for(int k = c[i][1]; k < (c[i][1] + 10); k++) {
					arr[m][k] = 1;
				}
			}
		}
		
		// 넓이 구하기
		int cnt = 0;
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				if(arr[i][j] == 1) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
}