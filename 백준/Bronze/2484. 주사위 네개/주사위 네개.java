import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int sum = 0;
		
		for(int i = 0; i < N; i++) {
			// 주사위 눈 선언
			int[] dice = new int[7];
			
			// 입력 받은 눈 갯수 세기
			for(int j = 0; j < 4; j++) {
				dice[sc.nextInt()]++;
			}
			
			int cntTwo = 0;	// 2개씩 나온 쌍의 갯수 세기
			int cntOne = 0;
			for(int j = 1; j < 7; j++) {
				// 같은 눈이 4개
				if(dice[j] == 4) {
					sum = Math.max(50000 + (j * 5000), sum);
					break;
				}
				// 같은 눈이 3개
				else if(dice[j] == 3) {
					sum = Math.max(10000 + (j * 1000), sum);
					break;
				}
				// 1. 같은 눈이 2개씩 두 쌍일 때
				// 2. 같은 눈이 2개만 한 쌍 나오는 경우
				else if(dice[j] == 2) {
					cntTwo++;
					
					if(cntTwo == 2) {
						break;
					}
				}
				else if(dice[j] == 1) {
					cntOne++;
					
					if(cntOne == 3) {
						break;
					}
				}
			}
			
			// 1. 같은 눈이 2개씩 두 쌍일 때
			if(cntTwo == 2) {
				int tmp = 2000;
				for(int j = 1; j < 7; j++) {
					if(dice[j] == 2) {
						tmp += (j * 500);
					}
				}
				sum = Math.max(tmp, sum);
			}
			// 2. 같은 눈이 2개만 나오는 경우
			if(cntTwo == 1) {
				for(int j = 1; j < 7; j++) {
					if(dice[j] == 2) {
						sum = Math.max(1000 + (j * 100), sum);
						break;
					}
				}
			}
			
			// 모두 다른 눈이 나오는 경우
			if(cntOne == 3) {
				int maxNum = 0;
				for(int j = 1; j < 7; j++) {
					if(dice[j] == 1) {
						maxNum = Math.max(maxNum, j);
					}
				}
				sum = Math.max(maxNum * 100, sum);
			}
		}	// N 개의 줄 입력 끝
		
		System.out.println(sum);
	}
}