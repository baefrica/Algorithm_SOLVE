import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 파싱 : StringTokenizer 를 통해 ',' 기준으로 분리한다
		StringTokenizer st;
		
		int T = sc.nextInt();
		for(int tc = 0; tc < T; tc++) {
			String num = sc.next();
			
			st = new StringTokenizer(num, ",");
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			System.out.println(a + b);
		}
	}
}
