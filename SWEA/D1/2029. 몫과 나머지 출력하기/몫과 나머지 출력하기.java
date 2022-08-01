import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int[][] arr = new int[T][2];
		
		for(int t = 0; t < T; t++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			arr[t][0] = (a / b);
			arr[t][1] = (a % b);
		}
		
		for(int t = 0; t < T; t++) {
			System.out.printf("#%d %d %d\n", (t + 1), arr[t][0], arr[t][1]);
		}
	}
}