import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		int d = 1;
		System.out.print(d + " ");
		for(int i = 0; i < num; i++) {
			d *= 2;
			System.out.print(d + " ");
		}
	}
}