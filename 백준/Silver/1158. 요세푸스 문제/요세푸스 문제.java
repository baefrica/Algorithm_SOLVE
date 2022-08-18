import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Queue<Integer> josephus = new LinkedList<>();
		
		// 총 인원 수
		int N = sc.nextInt();
		// K 번째 사람 제거
		int K = sc.nextInt();
		// 제거된 사람을 차례대로 집어넣을 배열
		int[] arr = new int[N];
		
		// 1번부터 N번까지 사람들에게 차례대로 번호를 부여
		for(int i = 1; i <= N; i++) {
			josephus.add(i);
		}
		
		// 다 제거할 때까지 반복문 돌리기
		for(int i = 0; i < N; i++) {
			// K 번째에 제거를 해야하는데, 그 K 번째를 세기 위해서 카운팅
			int cnt = 1;
			
			// K 번째 전까지 살려두는 사람을 뒤로 보낸다
			while(cnt < K) {
				josephus.add(josephus.poll());
				cnt++;
			}
			
			// K 번째에서 제거하고 제거된 사람배열에 집어넣는다
			arr[i] = josephus.poll();
		}
		
		// 출력
		System.out.print("<");
		for(int i = 0; i < (N - 1); i++) {
			System.out.print(arr[i] + ", ");
		}
		System.out.print(arr[N-1] + ">");
	}
}