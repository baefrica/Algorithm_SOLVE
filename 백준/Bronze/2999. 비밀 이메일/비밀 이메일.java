import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String message = sc.next();				// 상근이가 받은 메시지
		int mesLeng = message.length();		// 상근이가 받은 메시지의 길이
		
		// R 과 C 찾기
		int R = 0;
		int C = 0;
		for(int i = 1; i <= mesLeng; i++) {
			if(mesLeng % i == 0) {
				if(i > (mesLeng / i)) {
					break;
				}
				else {
					R = i;
					C = (mesLeng / i);
				}
			}
		}
		
		// 정인이가 암호화 한걸 역으로 행렬에 넣어봄
		char[][] arr = new char[R][C];
		int k = 0;
		for(int j = 0; j < C; j++) {
			for(int i = 0; i < R; i++) {
				arr[i][j] = message.charAt(k);
				k++;
			}
		}
		
		// 출력
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				System.out.print(arr[i][j]);
			}
		}
	}
}