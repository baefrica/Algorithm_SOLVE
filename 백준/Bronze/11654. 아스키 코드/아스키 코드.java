import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// char 형태로 문자를 받아서
		char a = sc.next().charAt(0);
		
		// int 형으로 출력 해준다
		System.out.println((int)a);
	}
}