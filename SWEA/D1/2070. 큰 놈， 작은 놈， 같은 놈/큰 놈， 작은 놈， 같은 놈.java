import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		String[] arr = new String[T];
		
		for(int t = 0; t < T; t++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			if(a < b) {
				arr[t] = "<";
			}
			else if(a == b) {
				arr[t] = "=";
			}
			else {
				arr[t] = ">";
			}
		}
		
		for(int t = 0; t < T; t++) {
			System.out.printf("#%d %s\n", (t + 1), arr[t]);
		}
	}
}