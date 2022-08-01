import java.util.Scanner;

public class Solution {
	public static void main(String[] arg) {
		Scanner sc = new Scanner(System.in);
		
		int P = sc.nextInt();// 비밀번호
		int K = sc.nextInt();
		
		int cnt = 0;
		for(int i = K; i <= P; i++) {
			cnt++;
		}
		System.out.println(cnt);
	}
}