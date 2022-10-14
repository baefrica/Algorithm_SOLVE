import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		N--;
		
		int k = 1;
		while(true) {
			if(k * (k+1) == N) {
				break;
			}
			else {
				k++;
			}
		}
		
		System.out.println(k);
	}
}