import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long A = sc.nextLong();
		long B = sc.nextLong();
		
		long M = Math.max(A, B);
		long m = Math.min(A, B);
		
		// 반례 : 두 수가 같을 때
		if(M == m) {
			System.out.println(0);
		}
		else {
			System.out.println((M - m - 1));
			
			for(long i = (m + 1); i < M; i++) {
				System.out.print(i + " ");
			}
		}
		
	}
}