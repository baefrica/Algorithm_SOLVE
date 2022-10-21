import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int S = sc.nextInt();
		int A = sc.nextInt();
		
		System.out.println(Math.min(S, A) / 2);
	}
}