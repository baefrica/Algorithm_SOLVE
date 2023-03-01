import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Integer> queue = new LinkedList<>();
		StringBuilder sb = new StringBuilder();

		int N = sc.nextInt();
		int back = -1; // back 명령을 받았을 때 확인하기 위한 용도
		for (int i = 0; i < N; i++) {
			String order = sc.next();

			if (order.equals("push")) {
				int num = sc.nextInt();
				queue.offer(num); // null 반환
				back = num;
//				queue.add(num);		// 예외 발생
			} else if (order.equals("pop")) {
				if (queue.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(queue.poll()).append("\n");
//					queue.remove();	// 예외 발생
				}
			} else if (order.equals("size")) {
				sb.append(queue.size()).append("\n");
			} else if (order.equals("empty")) {
				if (queue.isEmpty()) {
					sb.append(1).append("\n");
				} else {
					sb.append(0).append("\n");
				}
			} else if (order.equals("front")) {
				if (queue.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(queue.peek()).append("\n");
//					queue.element();	// 예외 발생
				}
			} else {
				if (queue.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(back).append("\n");
				}
			}
		} // for문 끝
		System.out.print(sb);
	}
}

//15
//push 1
//push 2
//front
//back
//size
//empty
//pop
//pop
//pop
//size
//empty
//pop
//push 3
//empty
//front
