import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String N = sc.next();
		int[] arr = new int[N.length()];
		
		for(int i = 0; i < N.length(); i++) {
			arr[i] = N.charAt(i) - 48;
		}
		
		// 오름차순 정렬하고
		Arrays.sort(arr);
		// 거꾸로 출력
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[arr.length - i - 1]);
		}
	}
}