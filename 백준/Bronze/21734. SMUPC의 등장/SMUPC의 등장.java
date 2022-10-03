import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String S = sc.next();
		
		for(int i = 0; i < S.length(); i++) {
			// 각 알파벳에 해당하는 아스키코드 값을 10진법으로 나타낸 것을 문자열로 변환
			String s = Integer.toString(S.charAt(i) - 0);
			// 각 자리의 합
			int sum = 0;
			for(int j = 0; j < s.length(); j++) {
				sum += (s.charAt(j) - 48);
			}
			// 출력
			for(int j = 0; j < sum; j++) {
				System.out.print(S.charAt(i));
			}
			System.out.println();
		}
	}
}