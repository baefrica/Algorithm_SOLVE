import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String alpha = sc.next();
		int[] cnt = new int[26];
		
		// A : 0, Z : 25, a : 32, z : 57
		for(int i = 0; i < alpha.length(); i++) {
			if((alpha.charAt(i) - 65) <= 25) {
				cnt[alpha.charAt(i) - 65]++;
			}
			else {
				cnt[alpha.charAt(i) - 97]++;
			}
		}
		
		// 가장 많이 사용된 알파벳의 갯수
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < cnt.length; i++) {
			max = Math.max(max, cnt[i]);
		}
		
		int maxCnt = 0;		// 가장 많이 사용된 알파벳이 몇개냐
		int idx = 0;			// 가장 많이 사용된 알파벳의 위치
		for(int i = 0; i < cnt.length; i++) {
			if(cnt[i] == max) {
				maxCnt++;
				idx = i;
			}
		}
		
		if(maxCnt > 1) {
			System.out.println("?");
		}
		// 아스키코드 값으로 출력
		else {
			System.out.println((char)(idx + 65));
		}
	}
}