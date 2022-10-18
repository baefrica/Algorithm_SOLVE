import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// (1 ≤ M < N ≤ 10)
		int N = sc.nextInt();		// 스크린은 N 칸으로 나누어져 있다
		int M = sc.nextInt();		// 바쿠니 칸
		int J = sc.nextInt();		// 떨어지는 사과의 갯수 (1 ≤ J ≤ 20)
		
		int curr = M;		// 바구니 젤 오른칸 현위치
		int ans = 0;	// 움직이는 거리의 합
		
		// 떨어지는 사과의 위치를 순서대로 입력받는다
		for(int i = 0; i < J; i++) {
			int apple = sc.nextInt();
			
			// 떨어지는 사과의 위치가 내 젤 오른쪽보다 크다면
			if(apple > curr) {
				// 오른칸을 그만큼 이동시켜주고
				ans += (apple - curr);
				// 현재칸이 오른칸 된다
				curr = apple;
//				System.out.println(ans);
//				System.out.println(curr);
//				System.out.println();
			}
			else {
				// 내 젤 왼칸 바로 옆부터 왼쪽으로 사과가 떨어진다면
				if(apple <= (curr - M)) {
					// 그만큼 거리 이동하고
					ans += (curr - M + 1 - apple);
					// 현 위치는 내 젤 왼쪽에서 M칸 가면 내 젤 오른쪽 칸이 됨
					curr = (apple + M - 1);
//					System.out.println(ans);
//					System.out.println(curr);
//					System.out.println();
				}
			}
		}
		
		System.out.println(ans);
	}	// main 끝
}