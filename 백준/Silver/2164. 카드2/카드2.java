import java.util.Scanner;

public class Main {
	static int[] card;
	static int front = 0;
	static int rear;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		// 배열의 크기를 (2 * N) 으로 해준다
		card = new int[2 * N];
		for(int n = 0; n < N; n++) {
			card[n] = (n + 1);
		}
		
		rear = (N - 1);
		// front == rear 일 때까지 반복
		while(front != rear) {
			deQueue();
			enQueue();
		}
		System.out.println(card[front]);
	}
	// 1. 맨 위의 카드 삭제하기
	public static void deQueue() {
		card[front++] = 0;
	}
	// 2. 맨 위의 카드를 아래로 보내기
	public static void enQueue() {
		card[rear+1] = card[front];
		front++;
		rear++;
	}
	// 배열의 크기를 N으로 했을 때 시간초과나는..
//	public static void deQueue() {
//		card[front] = 0;
//		
//		for(int i = front; i < rear; i++) {
//			card[i] = card[i+1];
//		}
//		rear--;
//	}
//	public static void enQueue() {
//		card[rear+1] = card[front++];
//		rear++;
//	}
}