import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
	
	static class Node {
        int data;
        Node link;
        
        public Node(int data) {
            this.data = data;
            this.link = null;
        }
    }
	
    static class LinkedQueue {
        Node front;
        Node rear;
        int size;
        
        // isEmpty
        public boolean isEmpty() {
            if(front == null) {
                return true;
            }
            else {
            	return false;
            }
        }
        
        // enQueue
        public void enQueue(int data) {
        	// 새로운 노드 생성
        	Node node = new Node(data);
        	// 비어있다면 첫 자리에 들어가도록 세팅
            if(isEmpty()) {
            	front = node;
            	rear = node;
            	size++;
            }
            // 아니면 맨 뒤에 들어가도록 세팅
            else {
            	// 새로운 node가 맨 뒤의 다음 놈이 되도록 세팅
            	rear.link = node;
            	// 들어온 내가 꼴지이니깐 rear 표시
                rear = node;
                size++;
            }
        }
        
        // deQueue
        public int deQueue() {
            if(isEmpty()) {
            	return -1;
            }
            else {
            	// 첫번째 값
            	int firstData = front.data;
            	// 두번째(첫번째의 다음놈 front.link)를 첫번째로
                front = front.link;
                size--;
                return firstData;
            }
        }
        
        // printQueue
        public void printQueue() {
        	// 첫번째 노드에서 출발
            Node cur = front;
            // 노드가 없을 때까지
            while(cur != null) {
            	// 하나씩 꺼내고 다음 놈으로 이동
                System.out.print(cur.data + " ");
                cur = cur.link;
            }
            System.out.println();
        }
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc = 1; tc <= 10; tc++) {
			LinkedQueue linkedqueue = new LinkedQueue();
			int t = sc.nextInt();
			
			// 8개의 수를 입력 받으면서 큐에 삽입
			for(int i = 0; i < 8; i++) {
				linkedqueue.enQueue(sc.nextInt());
			}
			
			// 전체 반복문을 끝내기 위한 방법
			Loop:
			while(true) {
				for(int i = 1; i <= 5; i++) {
					int k = (linkedqueue.deQueue() - i);
					// 0 이하가 되면 0으로 고정시키고 반복문 전체를 종료
					if(k <= 0) {
						k = 0;
						linkedqueue.enQueue(k);
//						linkedqueue.deQueue();
						break Loop;
					}
					linkedqueue.enQueue(k);
//					linkedqueue.deQueue();
				}
			}
				System.out.print("#" + t + " ");
				linkedqueue.printQueue();
		}
	}
}