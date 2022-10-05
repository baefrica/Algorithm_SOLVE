import java.util.Scanner;

public class Main {
	public static int f(int n) {
		if(n == 1) {
			return 1;
		}
		else if(n == 2) {
			return 2;
		}
		else if(n == 3) {
			return 4;
		}
		else {
			return f(n-1) + f(n-2) + f(n-3);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 0; tc < T; tc++) {
//			int n = sc.nextInt();	// n 은 양수이며 11보다 작다
			
			// n 을 1, 2, 3의 합으로 나타내는 방법의 수
			System.out.println(f(sc.nextInt()));
		}	// 테케 끝
	}
}