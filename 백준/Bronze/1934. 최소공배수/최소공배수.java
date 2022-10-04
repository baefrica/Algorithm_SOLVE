import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t = 0; t < T; t++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			int M = Math.max(A, B);
			int m = Math.min(A, B);
			
			int k = 1;
			int ans = 0;
			
			while(true) {
				if((M * k) % m == 0) {
					ans = (M * k);
					break;
				}
				else {
					k++;
				}
			}
			
			System.out.println(ans);
		}
	}
}