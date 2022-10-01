import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[3];
		for(int i = 0; i < 3; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i = 0; i < 2; i++) {
			for(int j = i+1; j < 3; j++) {
				if(arr[i] > arr[j]) {
					int tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
		}
		
		for(int i = 0; i < 3; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}