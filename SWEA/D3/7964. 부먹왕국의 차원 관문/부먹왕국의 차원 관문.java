import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int x = 1; x <= T; x++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#" + x + " ");
			
			int N = sc.nextInt();
			int D = sc.nextInt();
			
			int cnt = 0;
			int ans = 0;
			
			for(int n = 0; n < N; n++) {
				// 도시 입력 받을 때마다
				int city = sc.nextInt();
				
				// 관문 없으면 카운팅				
				if(city == 0) {
					cnt++;
				}
				// 관문 있으면 카운팅 리셋
				else {
					cnt = 0;
				}
				
				// 차원관문이 없는 도시가 D 만큼 연속되면 차원관문 하나 만들어줘야 한다
				if(cnt == D) {
					ans++;
					cnt = 0;
				}
			}
			
			sb.append(ans);
			System.out.println(sb);
		}
	}
}