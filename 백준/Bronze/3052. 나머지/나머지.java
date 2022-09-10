import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 나머지를 체크할 배열을 생성한다
		int[] mod = new int[42];
		// 42로 나눈 나머지를 센다
		for(int i = 0; i < 10; i++) {
			int num = sc.nextInt();
			mod[num % 42]++;
		}
		
		int cnt = 0;
		// 나머지 배열을 돌면서 값이 있다면 카운팅을 한다
		for(int i = 0; i < mod.length; i++) {
			if(mod[i] != 0) {
				cnt++;
			}
		}
		
		// 카운팅 만 출력
		System.out.println(cnt);
	}
}