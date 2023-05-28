import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a1 = sc.nextInt();
		int a0 = sc.nextInt();
		int c = sc.nextInt();
		int n0 = sc.nextInt();

		
		if(c > a1) {
			int tmp = a0 / (c - a1);
			
			if (n0 < tmp) {
				System.out.println(0);
			} else {
				System.out.println(1);
			}
		}
		// c = a1 일 경우를 위해
		else if(c == a1) {
			System.out.println(1);
		}
		else {
			System.out.println(0);
		}
	}
}
