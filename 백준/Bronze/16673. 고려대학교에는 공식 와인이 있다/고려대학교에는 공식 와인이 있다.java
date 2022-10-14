import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int C = sc.nextInt();
		int K = sc.nextInt();
		int P = sc.nextInt();
		
		int sum = 0;
		for(int i = 0; i <= C; i++) {
			sum += (K * i) + (P * i * i);
		}
		System.out.println(sum);
	}
}
