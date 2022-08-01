import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			String s = sc.next();
			String s_reverse = "";
			
			for(int i = s.length() - 1; i >= 0; i--) {
				s_reverse += s.charAt(i);
			}
			System.out.printf("#%d %d\n", t, (s.equals(s_reverse) ? 1 : 0));
		}
	}
}