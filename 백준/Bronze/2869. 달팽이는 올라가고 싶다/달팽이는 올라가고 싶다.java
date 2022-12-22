import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		int V = sc.nextInt();
		
		int day = (V - A) / (A - B);
		// 나머지가 존재 X
		if( (V - A) % (A - B) == 0 ) {
			day++;
		}
		// 나머지가 존재한다
		else {
			day += 2;
		}
		System.out.println(day);
	}
}
