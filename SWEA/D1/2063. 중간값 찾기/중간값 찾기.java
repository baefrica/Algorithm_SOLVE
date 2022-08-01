import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		int n = sc.nextInt();
		
		int array[] = new int[n]; // n은 칸 수
		
		for (int i = 0; i < n; i++) {
			array[i] = sc.nextInt();
		}
		
		Arrays.sort(array); //
		
		System.out.println(array[(n / 2)]);
	}

}