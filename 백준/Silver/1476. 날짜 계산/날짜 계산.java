import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int E = sc.nextInt();		// 15이하
		int S = sc.nextInt();		// 28이하
		int M = sc.nextInt();		// 19이하
		
		int[] date = { 1, 1, 1 };
		int cnt = 1;
		while(true) {
			if(date[0] == E && date[1] == S && date[2] == M) {
				System.out.println(cnt);
				break;
			}
			else {
				date[0]++;
				date[1]++;
				date[2]++;
				cnt++;
			}
			
			if(date[0] > 15) {
				date[0] = 1;
			}
			if(date[1] > 28) {
				date[1] = 1;
			}
			if(date[2] > 19) {
				date[2] = 1;
			}
		}
	}
}