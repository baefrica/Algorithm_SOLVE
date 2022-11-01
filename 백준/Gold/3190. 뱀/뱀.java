import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

class Node {
	int r, c;
	String dir;
	
	public Node(int r, int c, String dir) {
		this.r = r;
		this.c = c;
		this.dir = dir;
	}
}

public class Main {
	static Node node;
	static int idx = 0;		// 나중에 초수랑 방향전환 배열 인덱스값에 이용
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();								// 보드의 크기
		int[][] board = new int[N+2][N+2];		// 보드판 생성 (벽 포함)
		
		// 뱀의 위치를 true로 나타낼 려고
		// 자기 몸에 부딪치면 죽게 하려고
		boolean[][] snakeInfo = new boolean[N+2][N+2];
		
		int K = sc.nextInt();	// 사과의 개수
		// 사과의 위치
		for(int i = 0; i < K; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			board[r][c] = 9;		// 사과가 있다고 표시함
		}
		
		int L = sc.nextInt();	// 뱀의 방향 변환 횟수
		// 게임 시작 시간으로부터 X초가 끝난 뒤에
		// 왼쪽(C가 'L') 또는 오른쪽(C가 'D')으로 90도 방향을 회전시킨다는 뜻
		int[] X = new int[L];					// 초수 담았어
		String[] C = new String[L];		// 그 초수 일 때 방향 전환 담았어
		for(int i = 0; i < L; i++) {
			X[i] = sc.nextInt();
			C[i] = sc.next();
		}
		// 입력 끝
		
		// 뱀의 현위치 좌표를 노드형태로 덱큐에 담을 거임
		// 이동할 때마다 머리는 삽입
		// 사과 먹으면 꼬리는 그대로, 안 먹으면 꼬리 삭제
		Deque<Node> snake = new ArrayDeque<>();		// 양 옆으로 넣고 빼고 할거다
		
		snake.add(new Node(1, 1, "right"));	// 뱀의 머리 삽입
		snakeInfo[1][1] = true;		// 뱀의 현 위치 표시
		
		int cnt = 0;	// 겜이 몇 초에 끝나는 지 볼라고
		boolean isStop = false;		// true 이면 방향 전환 그만
		boolean isDie = false;		// true 이면 뱀 죽고 게임 끝
		
		while(true) {
			cnt++;	// 1초 지남
//			System.out.println("cnt : " + cnt);
//			System.out.println("idx : " + idx);
			
			// 머리를 빼낸다.
			node = snake.peekFirst();
			
			// 뱀의 이동방향을 보자
			int nr = 0;
			int nc = 0;
			switch(node.dir) {
			case "right" :
				nr = node.r;
				nc = node.c + 1;
				
				// 뱀이 죽는 조건
				if(nr == 0 || nr == (N + 1) || nc == 0 || nc == (N + 1)) {
					isDie = true;
					break;
				}
				if(snakeInfo[nr][nc] == true) {
					isDie = true;
					break;
				}
				
				// 방향 전환해야 할 때인지 확인하고
				// 방향 바꿔!
				if(!isStop) {
					if(cnt == X[idx]) {
						if(C[idx].equals("D")) {
							node.dir = "down";
						}
						else {
							node.dir = "up";
						}
						
						idx++;
					}
				}
				
				break;
			
			case "left" :
				nr = node.r;
				nc = node.c - 1;
				
				// 뱀이 죽는 조건
				if(nr == 0 || nr == (N + 1) || nc == 0 || nc == (N + 1)) {
					isDie = true;
					break;
				}
				if(snakeInfo[nr][nc] == true) {
					isDie = true;
					break;
				}
				
				// 방향 전환해야 할 때인지 확인하고
				// 방향 바꿔!
				if(!isStop) {
					if(cnt == X[idx]) {
						if(C[idx].equals("D")) {
							node.dir = "up";
						}
						else {
							node.dir = "down";
						}
						
						idx++;
					}
				}
				
				break;
			
			case "up" :
				nr = node.r - 1;
				nc = node.c;
				
				// 뱀이 죽는 조건
				if(nr == 0 || nr == (N + 1) || nc == 0 || nc == (N + 1)) {
					isDie = true;
					break;
				}
				if(snakeInfo[nr][nc] == true) {
					isDie = true;
					break;
				}
				
				// 방향 전환해야 할 때인지 확인하고
				// 방향 바꿔!
				if(!isStop) {
					if(cnt == X[idx]) {
						if(C[idx].equals("D")) {
							node.dir = "right";
						}
						else {
							node.dir = "left";
						}
						
						idx++;
					}
				}
				
				break;
			
			case "down" :
				nr = node.r + 1;
				nc = node.c;
				
				// 뱀이 죽는 조건
				if(nr == 0 || nr == (N + 1) || nc == 0 || nc == (N + 1)) {
					isDie = true;
					break;
				}
				if(snakeInfo[nr][nc] == true) {
					isDie = true;
					break;
				}
				
				// 방향 전환해야 할 때인지 확인하고
				// 방향 바꿔!
				if(!isStop) {
					if(cnt == X[idx]) {
						if(C[idx].equals("D")) {
							node.dir = "left";
						}
						else {
							node.dir = "right";
						}
						
						idx++;
					}
				}
				
				
				break;
			}	// switch 문 끝
			
			// 죽었다면 게임 끝내자
			if(isDie) {
				break;
			}
			
			// 이동한 뱀의 머리 (정보)를 맨 앞에 담고
			snake.addFirst(new Node(nr, nc, node.dir));
			// 뱀이 있다고 위치 표시
			snakeInfo[nr][nc] = true;
			
			// 머리가 간 자리에 사과가 없다면
			// 꼬리를 큐에서 빼고 뱀 위치는 false 로 돌려놔
			if(board[nr][nc] != 9) {
				snakeInfo[snake.peekLast().r][snake.peekLast().c] = false;
				snake.pollLast();
			}
			// 사과 있으면
			// 사과 먹고 사과 이제 없다고 표시
			else {
				board[nr][nc] = 0;
			}
			
			// 방향 전환 그만! 조건
			if(idx == L) {
				isStop = true;
			}
		}	// while 문 끝
		
		System.out.println(cnt);
	}
}

//#input :
//10
//4
//1 2
//1 3
//1 4
//1 5
//4
//8 D
//10 D
//11 D
//13 L
