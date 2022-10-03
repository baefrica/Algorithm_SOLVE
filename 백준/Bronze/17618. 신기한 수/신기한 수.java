import java.util.Scanner;

public class Main {
	// 해당 수의 자릿 수를 더한 합을 구하는 함수
	public static int sum(int n) {
		// 문자열로 변환
		String N = Integer.toString(n);
		int sum = 0;
		
		// 각 자릿수의 합을 구한다
		for(int i = 0; i < N.length(); i++) {
			sum += (N.charAt(i) - 48);
		}
		
		return sum;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String N = sc.next();
		// 문자열로 받은 숫자를 정수형으로
		int n = Integer.parseInt(N);
		// 카운팅 초기화
		int cnt = 0;		
		// 신기한 수라면 카운팅 !
		for(int i = n; i > 0; i--) {
			if(i % sum(i) == 0) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
}