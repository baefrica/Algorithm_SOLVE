import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int x = 1; x <= T; x++) {
			// 사람 수를 입력 받는다
			int N = sc.nextInt();
			// 몇 초 마다 붕어빵 만들어지는지 입력 받는다
			int M = sc.nextInt();
			// 붕어빵 몇 개씩 만들어지는지 입력 받는다
			int K = sc.nextInt();
			
			// 붕어빵 사러 오는 사람들이 몇초에 오는지 초수를 담을 배열 생성
			int[] arr = new int[N];
			
			// 배열을 입력 받는다
			for(int n = 0; n < N; n++) {
				arr[n] = sc.nextInt();
			}
			
			// 배열을 오름차순으로 정렬한다 (시간순으로 붕어빵 팔기 위해서)
			Arrays.sort(arr);
			
			System.out.print("#" + x + " ");
			
			Stack<Integer> bread = new Stack<>();
			
			Loop :
			// 1초씩 늘려간다
			for(int m = 0; m <= arr[N-1]; m++) {
				// 붕어빵(1이라고 표시) 추가한다 + M초 마다
				if(m % M == 0) {
					// 0초일 때는 붕어빵을 만들지 않는다
					if(m == 0) {
					}
					else {
						// K개 만큼 만든다
						for(int k = 0; k < K; k++) {
							bread.push(1);
						}
					}
				}
				
				// 붕어빵 판매
				int i = 0;
				while(i < N) {
					if(m == arr[i]) {
						// 스택이 비어서 붕어빵 팔 게 없으면 Impossible 출력하고 종료
						if(bread.isEmpty()) {
							System.out.println("Impossible");
							break Loop;
						}
						// 팔 게 있다면 하나씩 pop 해준다
						else {
							bread.pop();
						}
					}
					
					// 다음 사람으로 넘어가
					i++;
				}
				
				// 초수 끝까지 도달했으면 잘 팔았다는 거니깐 Possible 출력하고 종료
				if(m == arr[N-1]) {
					System.out.println("Possible");
					break;
				}
			}
		}
	}
}