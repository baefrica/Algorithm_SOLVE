import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String KDA = sc.next();
		// 특정 문자열을 기준으로 나누어서 배열에 넣을 때 사용한다..
		String[] kda = KDA.split("/");
//		System.out.println(Arrays.toString(kda));
		int K = Integer.parseInt(kda[0]);
		int D = Integer.parseInt(kda[1]);
		int A = Integer.parseInt(kda[2]);
//		System.out.println(K + " " + D + " " + A);
		
		if((K + A) < D || D == 0) {
			System.out.print("hasu");
		}
		else {
			System.out.print("gosu");
		}
	}
}