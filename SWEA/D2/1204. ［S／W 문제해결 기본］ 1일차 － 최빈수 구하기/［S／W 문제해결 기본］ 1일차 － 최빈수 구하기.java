import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t = 0; t < T; t++) {
			int[] arr = new int[101];	// 배열이 테스트케이스 for 문 안으로 들어와야함 .. 안그러면 이전께 남아있음 ..
			int tc = sc.nextInt();
			
			for(int i = 0; i < 1000; i++) {
				int score = sc.nextInt();
				arr[score]++;
			}
			
			int max = 0;	// 최빈도
			int manyScore = 0;	// 최빈값
			
			for(int i = 0; i < arr.length; i++) {
				if(arr[i] >= max) {	// 최빈도의 i 값을 바로 넣어버리면 for 문 중에 .. 들어간 최빈값과 최빈도를 비교하는 이상한 상황이 발생하게 됨 ..
					max = arr[i];
					manyScore = i;
				}
			}
			System.out.println("#" + tc + " " + manyScore);
		}
	}
}