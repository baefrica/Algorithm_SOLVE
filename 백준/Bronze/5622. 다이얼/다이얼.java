import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();	// 알파벳 대문자로 이루어짐
		int ans = 0;
		for(int i = 0; i < str.length(); i++) {
			int n = (str.charAt(i) - 65);
			if(n < 3) {
				ans += 3;
			}
			else if(n < 6) {
				ans += 4;
			}
			else if(n < 9) {
				ans += 5;
			}
			else if(n < 12) {
				ans += 6;
			}
			else if(n < 15) {
				ans += 7;
			}
			else if(n < 19) {
				ans += 8;
			}
			else if(n < 22) {
				ans += 9;
			}
			else {
				ans += 10;
			}
		}
		System.out.println(ans);
	}
}