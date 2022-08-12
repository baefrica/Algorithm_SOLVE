import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		String b = sc.next();
		int sum = 0;
		
		int ans3 = a * (b.charAt(2) - 48);
		int ans4 = a * (b.charAt(1) - 48);
		int ans5 = a * (b.charAt(0) - 48);
		
		int ans6 = ans3 + (ans4 * 10) + (ans5 * 100);
		
		System.out.println(ans3);
		System.out.println(ans4);
		System.out.println(ans5);
		System.out.println(ans6);
	}
}