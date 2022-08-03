import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String eng = sc.next();
		
		for(int i = 0; i < eng.length(); i++) {
			int num = eng.charAt(i);
			System.out.printf("%d ", (num - 64));
			
		}
	}
}