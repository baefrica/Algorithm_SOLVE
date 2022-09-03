import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = N; i >= 0; i--) {
			sb.append(i + " ");
		}
		System.out.println(sb);
	}
}