import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		
		boolean flag = false;
		int cnt = 0;
		for(int i = 0; i < str.length(); i++) {
			// 공백이 아니면
			if(str.charAt(i) != ' ') {
				// 이전에 공백이었다가 다시 단어가 시작하면 카운팅
				if(!flag) {
					cnt++;
				}
				// 단어가 진행중이라고 표시(true)
				flag = true;
			}
			// 공백이면 공백이라고 표시 (false)
			else {
				flag = false;
			}
		}
		
		System.out.println(cnt);
	}
}