import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			System.out.print("#" + t + " ");
			
			int N = sc.nextInt();
			int sum = 0;
			for(int n = 1; n <= N; n++) {
				// n이 짝수면 - 붙인다
				if(n % 2 == 0) {
					// 웬만하면 변수는 가지고 놀지말자
					sum -= n;
				}
				else {
					sum += n;
				}
			}
			System.out.println(sum);
		}
	}
}