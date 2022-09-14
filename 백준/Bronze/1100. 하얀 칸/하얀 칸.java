import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		char[][] chs = new char[8][8];
		
		int cnt = 0;
		
		// 체스판 상태 입력받기
		for(int i = 0; i < 8; i++) {
			String state = sc.next();
			for(int j = 0; j < 8; j++) {
				chs[i][j] = state.charAt(j);
				
				// 짝수 행에서는 짝수 열이 하얀 칸
				if(i % 2 == 0 && j % 2 == 0 && chs[i][j] == 'F') {
					cnt++;
				}
				// 홀수 행에서는 홀수 열이 하얀 칸
				if(i % 2 != 0 && j % 2 != 0 && chs[i][j] == 'F') {
					cnt++;
				}
			}
		}	// 입력 끝
		
		System.out.println(cnt);
	}
}