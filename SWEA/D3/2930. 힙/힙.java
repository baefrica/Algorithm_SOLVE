import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int x = 1; x <= T; x++) {
			int N = sc.nextInt();
			// 우선 순위 큐에서 우선 순위가 큰거 부터(최댓값) 뽑을 때
			PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
			StringBuilder sb = new StringBuilder();
			
			// 테스트케이스 넘버 출력
			sb.append("#" + x + " ");
			
			// N  개 만큼 돈다
			for(int n = 0; n < N; n++) {
				// 연산 1을 수행할 때
				if(sc.nextInt() == 1) {
					// 한번 더 입력 받고 삽입까지 해준다
					heap.offer(sc.nextInt());
				}
				// 연산 2를 수행할 때
				else {
					// 비어있다면 -1 출력
					if(heap.isEmpty()) {
						sb.append(-1 + " ");
					}
					// 우선순위가 젤 큰 걸 뽑아내고 삭제 해준다
					else {
						sb.append(heap.poll() + " ");
					}
				}
			}
			System.out.println(sb);
		}
	}
}