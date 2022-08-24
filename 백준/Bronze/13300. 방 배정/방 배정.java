import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int[][] arr = new int[N][2];
		
		// 배열로 입력 받기
		for(int n = 0; n < N; n++) {
			for(int i = 0; i < 2; i++) {
				arr[n][i] = sc.nextInt();
			}
		}
		
		int ans = 0;
		// 학년 별로 남학생, 여학생 수 담을 배열
		int[] mCnt = new int[6];
		int[] wCnt = new int[6];
		
		// 순서대로 학년 판별하고 성별 판별
		for(int n = 0; n < N; n++) {
			for(int i = 1; i <= 6; i++) {
				if(arr[n][1] == i) {
					if(arr[n][0] == 1) {
						mCnt[i-1]++;
					}
					else {
						wCnt[i-1]++;
					}
				}
			}
		}
		
		// 수를 보고 방 갯수 판별
		for(int i = 0; i < 6; i++) {
			if(mCnt[i] % K == 0) {
				ans += (mCnt[i] / K);
			}
			else {
				ans += ((mCnt[i] / K) + 1);
			}
				
			if(wCnt[i] % K == 0) {
				ans += (wCnt[i] / K);
			}
			else {
				ans += ((wCnt[i] / K) + 1);
			}
		}
		
		sb.append(ans);
		System.out.println(sb);
	}
}