import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int size = 10;
		int[] data = new int[size];
		int max = 0;
		
		for(int t = 1; t <= T; t++) {
			for(int i = 0; i < size; i++) {
				// 배열을 입력 받는다
				data[i] = sc.nextInt();
				// 최댓값 찾기
				if(max < data[i]) {
					max = data[i];
				}
			}
			
			// (최댓값 + 1) 크기의 카운팅 할 배열 생성
			int[] counts = new int[max+1];
			int[] temp = new int[size];
			
			// 카운팅 하기
			for(int i = 0; i < size; i++) {
				counts[data[i]]++;
			}
			
			// 누적합 구하기
			for(int i = 1; i < counts.length; i++) {
				counts[i] += counts[i-1];
			}
			
			// 새로이 정렬
			for(int i = (size - 1); i >= 0; i--) {
				counts[data[i]]--;
				temp[counts[data[i]]] = data[i];
			}
			
			// 합 초기화
			int sum = 0;
			// 중간값들을 더하기
			for(int i = 1; i < size - 1; i++) {
				sum += temp[i];
			}
			System.out.println("#" + t + " " + Math.round(((double)sum / (size - 2))));
		}
	}
}