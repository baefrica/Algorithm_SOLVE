import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] data = new int[N];
		int max = 0;
		int min = 0;
		
		// 데이터 입력받고 그 중 최댓값을 구하기
		for(int i = 0; i < N; i++) {
			data[i] = sc.nextInt();
			if(max < data[i]) {
				max = data[i];
			}
			if(min > data[i]) {
				min = data[i];
			}
		}
		
		// (최댓값 + 1) 크기의 카운팅 배열 생성
		int[] cnt = new int[max+1];
		int[] minus_cnt = new int[Math.abs(min)+1];
		int minusN = 0;
		
		// 카운팅 하기
		for(int i = 0; i < N; i++) {
			if(data[i] < 0) {
				minus_cnt[Math.abs(data[i])]++;
				minusN++;
			}
			else {
				cnt[data[i]]++;
			}
		}
		
		// 누적합 구하기
		for(int i = 1; i < cnt.length; i++) {
			cnt[i] += cnt[i-1];
		}
		for(int i = 1; i < minus_cnt.length; i++) {
			minus_cnt[i] += minus_cnt[i-1];
		}

		// 정렬된 sorted 배열 생성하고 카운팅배열에서 1씩 깎으면서 집어 넣기
		int[] sorted = new int[N-minusN];
		int[] minus_sorted = new int[minusN];
		
		for(int i = (N - 1); i >= 0; i--) {
			if(data[i] < 0) {
				minus_cnt[Math.abs(data[i])]--;
				minus_sorted[minus_cnt[Math.abs(data[i])]] = Math.abs(data[i]);
			}
			else {
				cnt[data[i]]--;
				sorted[cnt[data[i]]] = data[i];
			}
		}
		StringBuilder sb = new StringBuilder();
		// sorted 배열의 값을 하나씩 차례대로 출력
		for(int i = (minus_sorted.length - 1); i >= 0; i--) {
			sb.append(minus_sorted[i]*-1);
			sb.append("\n");
		}
		for(int i = 0; i < sorted.length; i++) {
			sb.append(sorted[i]);
			sb.append("\n");
		}
		System.out.print(sb);
	}
}