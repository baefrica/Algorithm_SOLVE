import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		boolean flag = false;	// true : 등차수열, false : 등비수열
		
		if((arr[2] - arr[1]) == (arr[1] - arr[0])) {
			flag = true;
			System.out.println(arr[N-1] + (arr[1] - arr[0]));
		}
		else {
			System.out.println(arr[N-1] * (arr[1] / arr[0]));
		}
	}
}