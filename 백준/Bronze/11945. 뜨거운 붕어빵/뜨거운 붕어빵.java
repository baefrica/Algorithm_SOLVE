import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// (0 ≤ N, M ≤ 10)
		int N = sc.nextInt();
		int M = sc.nextInt();
		String[] arr = new String[N];
		
		if(M != 0) {
			for(int i = 0; i < N; i++) {
				arr[i] = sc.next();
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				System.out.print(arr[i].charAt(M - 1 - j));
			}
			System.out.println();
		}
	}
}