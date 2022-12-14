import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[][] arr = new int[N][2];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < 2; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		int[] cnt = new int[N];
		Arrays.fill(cnt, 1);		// 덩치 등수는 (k + 1)
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				// 나는 제외
				if(i == j) {
					continue;
				}
				
				// 덩치가 나보다 큰 사람 수 세기
				if( (arr[i][0] < arr[j][0]) && (arr[i][1] < arr[j][1]) ) {
					cnt[i]++;
				}
			}
		}
		
		// 출력
		for(int i = 0; i < N; i++) {
			System.out.print(cnt[i] + " ");
		}
	}
}