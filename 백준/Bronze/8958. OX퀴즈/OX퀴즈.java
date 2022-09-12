import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t = 0; t < T; t++) {
			String ox = sc.next();
			
			// 연속된 O의 카운팅
			int cnt = 0;
			// 점수 기록
			int score = 0;
			
			for(int i = 0; i < ox.length(); i++) {
				if(ox.charAt(i) == 'O') {
					cnt++;
					score += cnt;
				}
				// X가 나오면 연속된 O 카운팅 리셋
				else {
					cnt = 0;
				}
			}
			
			System.out.println(score);
		}	// 테케 끝
	}
}