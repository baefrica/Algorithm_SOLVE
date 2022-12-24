import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		String str = sc.next();
		int cnt = 0;
		int idx = 0;
		while(true) {
			sb.append(str.charAt(idx));
			cnt++;
			idx++;
			
			if(cnt == 10) {
				cnt = 0;
				sb.append("\n");
			}
			if(idx == str.length()) {
				break;
			}
		}
		System.out.println(sb);
	}
}
