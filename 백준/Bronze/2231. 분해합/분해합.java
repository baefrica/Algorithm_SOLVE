import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		// N보다 크면 생성자가 될 수 없다.
		for(int i = 1; i <= N; i++) {
			int sum = i;
			int tmp = i;
			// sum : 일의 자리수부터 차례로 더해준다
			// tmp : 10으로 나눈 몫 저장
			while(tmp != 0) {
				sum += tmp % 10;
				tmp /= 10;
			}
			
			if(sum == N) {
				System.out.println(i);
				break;
			}
			else {
				if(i == N) {
					System.out.println(0);
				}
			}
		}
	}
}