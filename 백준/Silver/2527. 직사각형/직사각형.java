import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc = 0; tc < 4; tc++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int p1 = sc.nextInt();
			int q1 = sc.nextInt();
			
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			int p2 = sc.nextInt();
			int q2 = sc.nextInt();
			
			if(x1 > x2) {
				int tmp = 0;
				tmp = x1;
				x1 = x2;
				x2 = tmp;
				
				tmp = y1;
				y1 = y2;
				y2 = tmp;
				
				tmp = p1;
				p1 = p2;
				p2 = tmp;
				
				tmp = q1;
				q1 = q2;
				q2 = tmp;
			}
			
			// 두번째 직사각형의 x 값이 첫 번째 직사각형 오른쪽 x 값보다 클 때
			if((x2 > p1) || (y1 > q2) || (q1 < y2)) {
				System.out.println("d");
			}
			// 점으로 겹칠 때
			else if((p1 == x2 && y1 == q2) || (p1 == x2 && q1 == y2)) {
				System.out.println("c");
			}
			// 선분으로 겹칠 때
			else if(y1 == q2 || p1 == x2 || q1 == y2) {
				System.out.println("b");
			}
			else {
				System.out.println("a");
			}
		}
	}
}