import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int R1 = sc.nextInt();
		int S = sc.nextInt();
		
		// (R1 + R2) / 2 = S
		int R2 = (2 * S) - R1;
		System.out.println(R2);
	}
}