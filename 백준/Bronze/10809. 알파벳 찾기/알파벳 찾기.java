import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String S = sc.next();
		int[] cnt = new int[26];
		
		// 배열의 값들을 전부 -1로 초기화
		Arrays.fill(cnt, -1);
		
		// a 는 숫자형으로 97임을 이용
		for(int i = 0; i < S.length(); i++) {
			if(cnt[((int)S.charAt(i) - 97)] == -1) {
				cnt[((int)S.charAt(i) - 97)] = i;
			}
		}
		
		for(int i = 0; i < cnt.length; i++) {
			System.out.print(cnt[i] + " ");
		}
	}
}