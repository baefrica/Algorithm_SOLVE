import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int max = Integer.MIN_VALUE;
		int maxRow = 0;
		int maxCol = 0;
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				int n = sc.nextInt();
				
				if(n > max) {
					max = n;
					maxRow = (i + 1);
					maxCol = (j + 1);
				}
			}
		}
		
		System.out.println(max);
		System.out.println(maxRow + " " + maxCol);
	}
}
