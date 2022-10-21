import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int min = Integer.MAX_VALUE;
		String ans = "";
		
		for(int i = 0; i < N; i++) {
			String title = sc.next();
			int dif = sc.nextInt();
			
			min = Math.min(min, dif);
			// 모든 문제의 난이도가 다 다르대
			if(min == dif) {
				ans = title;
			}
		}
		
		System.out.println(ans);
	}
}