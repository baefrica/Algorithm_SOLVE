import java.util.Scanner;

public class Solution {
	public static void main(String[] arg) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();	// 1부터 9까지의 자연수
		int b = sc.nextInt();	// 1부터 9까지의 자연수
		System.out.println(a + b);
		System.out.println(a - b);
		System.out.println(a * b);
		System.out.println(a / b);
	}
}