import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int x = 1; x <= T; x++) {
			int N = sc.nextInt();
			int[] cnt = new int[10];
			int k = 1;
			
			Loop :
			while(true) {
				// N의 각 자리 숫자 카운팅
				int n = N * k;
				while(n != 0) {
					cnt[n % 10]++;
					n /= 10;
				}
				// 아직 안나온 숫자가 있다면 계속 k++ 해준다
				for(int i = 0; i < cnt.length; i++) {
					if(cnt[i] == 0) {
						k++;
						break;
					}
					if(i == 9) {
						break Loop;
					}
				}
			}
			System.out.println("#" + x + " " + (k * N));
		}	// 테케 끝
	}
}