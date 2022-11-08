import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int M = sc.nextInt();
		
		int ball = 1;
		
		for(int i = 0; i < M; i++) {
			int X = sc.nextInt();
			int Y = sc.nextInt();
			
			if(X != ball && Y == ball) {
				ball = X;
			}
			else if(Y != ball && X == ball){
				ball = Y;
			}
		}
		
		System.out.println(ball);
	}
}