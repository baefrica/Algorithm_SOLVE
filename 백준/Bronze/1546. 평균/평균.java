import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 과목 갯수
		int N = sc.nextInt();
		// 점수 중 최댓값
		double M = Integer.MIN_VALUE;
		// 점수 저장할 배열
		double[] score = new double[N];
		
		for(int i = 0; i < score.length; i++) {
			// 과목 갯수 만큼 점수를 입력받는다
			score[i] = sc.nextDouble();
			// 점수 중 최댓값을 구한다
			M = Math.max(M, score[i]);
		}
		
		double sum = 0;
		for(int i = 0; i < score.length; i++) {
			// 점수 조작한다
			score[i] = (double) (score[i] / M * 100);
			sum += score[i];
		}
		System.out.println(sum / score.length);
	}
}