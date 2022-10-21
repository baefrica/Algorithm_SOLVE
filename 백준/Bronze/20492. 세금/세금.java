import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		// 1. 전체 상금의 22%를 제세공과금으로 납부하는 경우
		int x = N - (N * 22 / 100);
		// 2. 상금의 80%를 필요 경비로 인정받고
		// 나머지 금액 중 22%만을 제세공과금으로 납부하는 경우
		int y = N - (N * 44 / 1000);
		
		System.out.println(x + " " + y);
	}
}