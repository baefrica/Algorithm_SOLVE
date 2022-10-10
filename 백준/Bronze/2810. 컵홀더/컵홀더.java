import java.util.Scanner;

public class Main {
	// main
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();			// 좌석 수 (1이상 50이하)
		String info = sc.next();		// 좌석 정보
		
		// L 의 갯수를 세보자
		int lCnt = 0;
		for(int i = 0; i < info.length(); i++) {
			if(info.charAt(i) == 'L') {
				lCnt++;
			}
		}
		
		int cupCnt = N + 1 - (lCnt / 2);	// 컵홀더 갯수
		
		if(cupCnt > N) {
			System.out.println(N);
		}
		else {
			System.out.println(cupCnt);
		}
	}
}