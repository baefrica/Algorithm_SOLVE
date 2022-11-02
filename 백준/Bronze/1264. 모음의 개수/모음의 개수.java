import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			String str = sc.nextLine();
			
			// 종료조건
			if(str.equals("#")) {
				break;
			}
			
			int cnt = 0;
			for(int i = 0; i < str.length(); i++) {
				char x = str.charAt(i);
				if(x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u') {
					cnt++;
				}
				if(x == 'A' || x == 'E' || x == 'I' || x == 'O' || x == 'U') {
					cnt++;
				}
			}
			
			System.out.println(cnt);
		}	//while 끝
	}
}