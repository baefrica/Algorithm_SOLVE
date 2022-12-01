import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		long sum = 0;
		// 몫과 나머지가 같은 경우는 몫마다 하나씩 밖에 없다
		for(long i = 0; i < N; i++) {
			sum += ((N * i) + i);
		}
		
		System.out.println(sum);
	}
}