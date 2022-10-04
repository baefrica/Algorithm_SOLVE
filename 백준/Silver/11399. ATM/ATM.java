import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] pArr = new int[N];
		
		for(int i = 0; i < N; i++) {
			pArr[i] = sc.nextInt();
		}
		
		Arrays.sort(pArr);
		
		int sum = 0;
		int ans = 0;
		for(int i = 0; i < N; i++) {
			sum = sum + pArr[i];
			ans += sum;
		}
		
		System.out.println(ans);
	}
}