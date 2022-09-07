import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int x = 1; x <= T; x++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			System.out.println("Case #" + x + ": " + (A + B));
		}
	}
}