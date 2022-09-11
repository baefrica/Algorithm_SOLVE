import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			System.out.print("#" + t + " ");
			int N = sc.nextInt();
			int[] arr = new int[N];
			for(int n = 0; n < N; n++) {
				arr[n] = sc.nextInt();
			}
			
			int tmp = 0;
			for(int i = 0; i < (arr.length - 1); i++) {
				for(int j = 0; j < (arr.length - 1); j++) {
					if(arr[j] > arr[j+1]) {
						tmp = arr[j];
						arr[j] = arr[j+1];
						arr[j+1] = tmp;
					}
				}
			}
			
			for(int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		}
	}
}