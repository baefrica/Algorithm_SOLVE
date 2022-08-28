import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
//		Scanner sc = new Scanner(System.in);
		// 버퍼드리더로 받아보자
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
//		int T = sc.nextInt();
		// 입력받은 걸 정수형으로
		int T = Integer.parseInt(br.readLine());
		
		// 계속 갖다 쓸 토큰 자르기용 st
		StringTokenizer st;
		
		for(int x = 1; x <= T; x++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#" + x + " ");
			
			// 입력받아서 자를 준비
			st = new StringTokenizer(br.readLine());
			
//			int N = sc.nextInt();
//			int D = sc.nextInt();
			// 잘라서 차례대로 정수형으로 받기
			int N = Integer.parseInt(st.nextToken());
			int D = Integer.parseInt(st.nextToken());
			
			int cnt = 0;
			int ans = 0;
			
			// 입력 받아서 자를 준비
			st = new StringTokenizer(br.readLine());
			
			for(int n = 0; n < N; n++) {
				// 도시 입력 받을 때마다
//				int city = sc.nextInt();
				// 잘라서 차례대로 정수형으로 받기
				int city = Integer.parseInt(st.nextToken());
				
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