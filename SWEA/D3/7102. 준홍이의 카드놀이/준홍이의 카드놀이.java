import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			System.out.print("#" + tc + " ");
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int[] cntArr = new int[N+M+1];
			
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= M; j++) {
					cntArr[i+j]++;
				}
			}
			
			int max = Integer.MIN_VALUE;
			for(int i = 0; i < cntArr.length; i++) {
				max = Math.max(max, cntArr[i]);
			}
			
			// 젤 많은 합 값들 출력
			for(int i = 0; i < cntArr.length; i++) {
				if(cntArr[i] == max) {
					System.out.print(i + " ");
				}
			}
			System.out.println();
		}
	}
}