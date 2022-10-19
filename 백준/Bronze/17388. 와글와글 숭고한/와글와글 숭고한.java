import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
        int S = sc.nextInt();
        int K = sc.nextInt();
        int H = sc.nextInt();
        
		if((S + K + H) >= 100) {
			System.out.print("OK");
		}
		else {
			if(Math.min(Math.min(S, K), H) == S) {
				System.out.print("Soongsil");
			}
			else if(Math.min(Math.min(S, K), H) == K) {
				System.out.print("Korea");
			}
			else {
				System.out.print("Hanyang");
			}
		}
    }
}