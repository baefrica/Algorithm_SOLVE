import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int k = sc.nextInt();
		
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		int tmp = 0;
		for(int i = 0; i < N; i++) {
			for(int j = i; j < N; j++) {
				if(arr[i] < arr[j]) {
					tmp = arr[j];
					arr[j] = arr[i];
					arr[i] = tmp;
				}
			}
		}
		
//		System.out.println(Arrays.toString(arr));
		
		System.out.println(arr[k-1]);
	}
}