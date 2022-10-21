import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		double def = a - (a * b / 100.0);
//		System.out.println(def);
		
		if(def >= 100) {
			System.out.println(0);
		}
		else {
			System.out.println(1);
		}
	}
}