import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int x = 1; x <= T; x++) {
			StringBuilder sb = new StringBuilder();
			
			int P = sc.nextInt();
			int Q = sc.nextInt();
			int R = sc.nextInt();
			int S = sc.nextInt();
			int W = sc.nextInt();
			
			// A회사 요금
			int A = 0;
			A = (P * W);
			
			// B회사 요금
			int B = 0;
			if(W <= R) {
				B = Q;
			}
			else {
				// 초과량은 (W - R)
				B = Q + ((W - R) * S);
			}
			
			sb.append("#" + x + " " + Math.min(A, B));
			System.out.println(sb);
		}
	}
}