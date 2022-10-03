import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int minBu = Integer.MAX_VALUE;
		int minBe = Integer.MAX_VALUE;
		
		for(int bu = 0; bu < 3; bu++) {
			minBu = Math.min(sc.nextInt(), minBu);
		}
		
		for(int be = 0; be < 2; be++) {
			minBe = Math.min(sc.nextInt(), minBe);
		}
		
		System.out.println(minBu + minBe - 50);
	}
}