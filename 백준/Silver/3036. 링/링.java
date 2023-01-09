import java.util.Scanner;

public class Main {
	// GCD : 최대공약수
	public static int GCD(int a, int b) {
		// b 가 더 크면, a랑 b 교환
		if(b < a) {
			int tmp = a;
			a = b;
			b = tmp;
		}
		
		while(a % b != 0) {
			int tmp = a % b;
			a = b;
			b = tmp;
		}
		
		return b;
	}
	
	// main
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int first = sc.nextInt();
		for(int i = 0; i < N-1; i++) {
			int next = sc.nextInt();
			int gcd = GCD( first, next );
			// 분모, 분자는 입력 받은 각 수를 최대공약수로 나눈거
			System.out.println( (first / gcd) + "/" + (next / gcd) );
		}
	}
}
