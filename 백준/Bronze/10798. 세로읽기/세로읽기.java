import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		char[][] alpha = new char[5][15];
		for(int i = 0; i < 5; i++) {
			String word = sc.next();
			for(int j = 0; j < 15; j++) {
				if(j == word.length()) {
					break;
				}
				alpha[i][j] = word.charAt(j);
			}
		}
		
		for(int j = 0; j < 15; j++) {
			for(int i = 0; i < 5; i++) {
				if( (alpha[i][j] - '0') != -48 ) {
					System.out.print(alpha[i][j]);
				}
			}
		}
	}
}
