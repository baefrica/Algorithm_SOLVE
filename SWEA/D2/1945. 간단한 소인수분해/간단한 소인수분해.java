import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int[] sArr = {2, 3, 5, 7, 11};
		int[][] arr = new int[T][5];
		
		for(int t = 0; t < T; t++) {
			int N = sc.nextInt();
			
			for(int i = 0; i < sArr.length; i++) {
				while(N % sArr[i] == 0) {
					N /= sArr[i];
					arr[t][i]++;
				}
			}
		}
		
		for(int t = 0; t < T; t++) {
			System.out.printf("#%d ", (t + 1));
			
			for(int i = 0; i < 5; i++) {
				System.out.print(arr[t][i] + " ");
			}
			System.out.println();
		}
	}
}