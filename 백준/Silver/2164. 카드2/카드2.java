import java.util.Scanner;

public class Main {
	static int[] card;
	static int front = 0;
	static int rear;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		card = new int[2 * N];
		for(int n = 0; n < N; n++) {
			card[n] = (n + 1);
		}
		
		rear = N - 1;
		
		int cnt = 1;
		
		while(front != rear) {
			int now = deQueue();
			if(cnt % 2 == 0) {
				enQueue(now);
			}
			cnt++;
		}
		System.out.println(card[front]);
	}
	
	public static int deQueue() {
		int removeValue= card[front];
		card[front++] = 0;
		
//		for(int i = 0; i < rear; i++) {
//			card[i] = card[i+1];
//		}
		
//		rear--;
		
		return removeValue;
	}
	public static void enQueue(int item) {
		card[rear+1] = item;
		rear++;
	}
}