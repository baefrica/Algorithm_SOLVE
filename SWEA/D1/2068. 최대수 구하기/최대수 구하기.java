import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[10];
		int[] max = new int[3];
		
		int T = sc.nextInt();

		for(int t = 1; t <= T; t++) {
			for(int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();

				if(arr[i] > max[t-1]) {
					max[t-1] = arr[i];
				}
			}
		}
		
		for(int t = 1; t <= T; t++) {
			System.out.println("#" + t + " " + max[t-1]);
		}
	}
}