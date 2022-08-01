import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			System.out.println("#" + t);
			
			String c[] = new String[N];
			int k[] = new int[N];
			
			int total = 0;
			
			for(int i = 0; i < N; i++) {
				c[i] = sc.next();
				k[i] = sc.nextInt();
				total += k[i];
			}
			
			String arr[] = new String[total];
			
			int cnt = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < k[i]; j++) {
					arr[cnt] = c[i];
					cnt++;
				}
			}
						
			for(int i = 0; i < cnt; i++){
				if(i != 0 && i % 10 == 0) {
					System.out.println();
				}
				System.out.print(arr[i]);
			}
			System.out.println();
		}
	}
}