import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		
		int cnt = 0;
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == '=' || str.charAt(i) == '-') {
				continue;
			}
			
			if(str.charAt(i) == 'z' && i > 0 && i < str.length()-1) {
				if(str.charAt(i-1) == 'd' && str.charAt(i+1) == '=') {
					continue;
				}
			}
			
			if(str.charAt(i) == 'j' && i > 0) {
				if(str.charAt(i-1) == 'l' || str.charAt(i-1) == 'n') {
					continue;
				}
			}
			
			cnt++;
		}
		
		System.out.println(cnt);
	}
}