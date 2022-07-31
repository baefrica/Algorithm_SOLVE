import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt(); // 자연수 A를 입력받는다.
		int B = sc.nextInt(); // 자연수 B를 입력받는다.
		
		System.out.println(A+B); // A+B를 계산한다.
		System.out.println(A-B); // A-B를 계산한다.
		System.out.println(A*B); // A*B를 계산한다.
		System.out.println(A/B); // A/B를 계산한다.
		System.out.println(A%B); // A%B를 계산한다.
	}
}