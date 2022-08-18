import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc = 1; tc <= 10; tc++) {
			int t = sc.nextInt();
			
			Queue<Integer> queue = new LinkedList<>();
			// 8개의 수를 입력 받으면서 큐에 삽입
			for(int i = 0; i < 8; i++) {
				queue.add(sc.nextInt());
			}
			
			// 전체 반복문을 끝내기 위한 방법
			Loop1:
			while(true) {
				for(int i = 1; i <= 5; i++) {
					int k = (queue.peek() - i);
					// 0 이하가 되면 0으로 고정시키고 반복문 전체를 종료
					if(k <= 0) {
						k = 0;
						queue.add(k);
						queue.poll();
						break Loop1;
					}
					queue.add(k);
					queue.poll();
				}
			}
			System.out.print("#" + t + " ");
			for(int i = 0; i < 8; i++) {
				System.out.print(queue.poll() + " ");
			}
			System.out.println();
		}
	}
}