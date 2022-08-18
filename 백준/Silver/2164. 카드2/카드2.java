import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int two = 1;
		
		while(two < N) {
			two *= 2;
			
			if(two > N) {
				two /= 2;
				break;
			}
		}
		
		if(two == N) {
			System.out.println(N);
		}
		else {
			System.out.println((N - two) * 2);
		}
	}
}