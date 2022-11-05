import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		
		int cnt = 0;
		for(int i = 0; i < str.length(); i++) {
			char x = str.charAt(i);
			if(x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u') {
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
}