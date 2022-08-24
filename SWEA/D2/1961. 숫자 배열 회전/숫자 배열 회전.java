import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#" + tc).append("\n");
			int N = sc.nextInt();
			
			char[][] arr = new char[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					arr[i][j] = sc.next().charAt(0);
				}
			}
			
			// 새로이 저장할 배열 생성
			String[][] newArr = new String[N][3];
			
			// 90도 회전
			int p = 0;
			int q = 0;
			
			for(int j = 0; j < N; j++) {
				String str = "";
				
				for(int i = (N - 1); i >= 0; i--) {
					str += arr[i][j];
				}
				newArr[p++][q] = str;
			}
			
			// 180도 회전
			p = 0;
			q = 1;
			
			for(int i = (N - 1); i >= 0; i--) {
				String str = "";
				
				for(int j = (N - 1); j >= 0; j--) {
					str += arr[i][j];
				}
				newArr[p++][q] = str;
			}
			
			// 270도 회전
			p = 0;
			q = 2;
			
			for(int j = (N - 1); j >= 0; j--) {
				String str = "";
				
				for(int i = 0; i < N; i++) {
					str += arr[i][j];
				}
				newArr[p++][q] = str;
			}
			
			for(int i = 0; i < (N - 1); i++) {
				for(int j = 0; j < 3; j++) {
					sb.append(newArr[i][j] + " ");
				}
				sb.append("\n");
			}
			for(int j = 0; j < 3; j++) {
				sb.append(newArr[N-1][j] + " ");
			}
			System.out.println(sb);
		}
	}
}