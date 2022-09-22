import java.util.Scanner;

public class Solution {
	static int N;
	static int M;
	
	// 거듭제곱 하는 함수입니다
	public static int pow(int n, int m) {
		// 1이 되면 자기자신으로 돌아가는 기저조건
		if(m == 1) {
			return n;
		}
		
		// 한번 분할해서 계산할 때 저장할 값
		int result = 0;
		
		// 짝수일 때
		if(m%2 == 0) {
			result = pow(n, m/2);
			return result * result;
		}
		// 홀수일 때
		else {
			result = pow(n, (m-1)/2);
			return result * result * n;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = 10;
		for(int t = 1; t <= T; t++) {
			int tc = sc.nextInt();
			N = sc.nextInt();
			M = sc.nextInt();
			
			System.out.println("#" + tc + " " + pow(N, M));
		}
	}
}