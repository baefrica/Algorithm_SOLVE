import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st;
		
		String S = sc.next();
		st = new StringTokenizer(S, ",");
		// 1. 토큰 갯수 세는 방법
		System.out.println(st.countTokens());
		
		// 2. 스프릿 사용하는 방법
		// split 사용하면 배열로 저장이 된다
//		System.out.println(S.split(",").length);
//		System.out.println(Arrays.toString(S.split(",")));
	}
}
