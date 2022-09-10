import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int div = 0;
		int mod = 0;
		int cnt = 0;
		
		// 계속 바뀌는 수 res 를 첨에는 N 으로 설정해줌
		int res = N;
		while(true) {
			// N 의 첫째 자리 수
			div = (res / 10);
			// N 의 둘째 자리 수
			mod = (res % 10);
			
			// 이전 수의 가장 오른쪽 자리 수와 구한 합의 가장 오른쪽 자리 수를 이어 붙인다
			res = (mod * 10) + ((div + mod) % 10);
			// 사이클 1회 돌았음
			cnt++;
			
			// 똑같아지면 while 문 탈출
			if(N == res) {
				break;
			}
		}
		
		//사이클만 출력
		System.out.println(cnt);
	}
}