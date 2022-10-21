import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int x1 = sc.nextInt();
		int y1 = sc.nextInt();
		int r1 = sc.nextInt();
		
		int x2 = sc.nextInt();
		int y2 = sc.nextInt();
		int r2 = sc.nextInt();
		
		// 두 원의 원점 사이의 거리가 두 반지름의 길이 합 보다 작아야 한다 !!
		// 제곱 할 때 : Math.pow
		// 제곱근 구할 때 : Math.sqrt
		if((r1 + r2) > Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2))) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
	}
}