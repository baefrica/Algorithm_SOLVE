import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();	// 3 이상 100 이하
		int M = sc.nextInt();	// 10 이상 300,000 이하
		Integer[] card = new Integer[N];
		int select[] = new int[3];
		
		for(int i = 0; i < card.length; i++) {
			card[i] = sc.nextInt();
		}
		
		Arrays.sort(card, Collections.reverseOrder());	// 내림차순 정렬
		
		int max = 0;
		
		// 카드 선택하기
		for(int i = 0; i < N; i++) {
			for(int j = i+1; j < N; j++) {
				for(int k = j+1; k < N; k++) {
					select[0] = card[i];
					select[1] = card[j];
					select[2] = card[k];
					
					int sum = 0;
					// 합 구하기
					for(int s : select) {
						sum += s;
					}
					if(sum > M) {
						continue;
					}
					else {
						if(sum > max) {
							max = sum;
						}
					}
				}
			}
		}
		System.out.println(max);
	}
}