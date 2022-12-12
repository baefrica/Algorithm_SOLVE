import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[N+1];
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		arr[N] = Integer.MAX_VALUE;
		
		Arrays.sort(arr);
		
		for(int i = 0; i < N; i++) {
			if(arr[i] == arr[i+1]) {
				continue;
			}
			else {
				System.out.print(arr[i] + " ");
			}
		}
	}
}