import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int movie = 665;
		int cnt = 0;
		// N 번째 영화의 제목에 들어간 수
		while(cnt != N) {
			movie++;
			
			// 666을 포함하면
			if(Integer.toString(movie).contains("666")) {
				cnt++;
			}
		}
		
		System.out.println(movie);
	}
}