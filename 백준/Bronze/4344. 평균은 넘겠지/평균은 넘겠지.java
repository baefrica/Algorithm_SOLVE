import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int C = sc.nextInt();
		for(int c = 0; c < C; c++) {
			int N = sc.nextInt();
			double[] score = new double[N];
			double sum = 0;
			
			// 입력 받으면서 합을 구한다
			for(int i = 0; i < N; i++) {
				score[i] = sc.nextDouble();
				sum += score[i];
			}
			
			// 평균을 구한다
			double avg = (sum / N);
			
			// 평균이 넘는 갯수를 센다
			double cnt = 0;
			for(int i = 0; i < N; i++) {
				if(score[i] > avg) {
					cnt++;
				}
			}
			
			double ans = (cnt / N) * 100;
			// 소수점 셋째자리까지 반올림하는데 뒤에 0을 절삭하지 않는 방법 : String.format()
			System.out.println(String.format("%.3f", ans) + "%");
			
		}	// 테케 끝
	}
}