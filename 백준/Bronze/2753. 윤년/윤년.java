import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 연도를 입력 받는다
		int year = sc.nextInt();
		
		if((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)) {
			System.out.println(1);
		}
		else {
			System.out.println(0);
		}
	}
}