import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int max = 1;
		int k = 0;
		
		// 주어진 수가 벌집 층 범위의 최댓값 보다 작아지는 순간 그 범위를 찾는 것이다
		while(N > max) {
			k++;
			// 벌집 한층 한층 넓어질수록 6의 배수만큼 많아진다
			max += (6 * k);
		}
		
		System.out.println(k + 1);
	}
}