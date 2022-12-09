import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long A = sc.nextLong();
		long B = sc.nextLong();
		long sum = 0;
		
//		System.out.println(Math.max(A, B));
//		System.out.println(Math.min(A, B));
//		System.out.println((Math.max(A, B) - Math.min(A, B) + 1));
		
		sum = (Math.max(A, B) - Math.min(A, B) + 1) * (A + B) / 2;
		
		System.out.println(sum);
	}
}