import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();		// 체스판 세로 길이
		int M = sc.nextInt();		// 체스판 가로 길이
		
		// 움직임..무조건 오른쪽으로만 이동..
		// 1. 2칸 위로, 1칸 오른쪽
		// 2. 1칸 위로, 2칸 오른쪽
		// 3. 1칸 아래로, 2칸 오른쪽
		// 4. 2칸 아래로, 1칸 오른쪽
		
		int ans = 0;
		// 이동 횟수가 4번 째 부터면 이동 방법을 모두 한번씩 꼭 사용해야 한다.
		// 이동 횟수가 4번보다 적은 경우에는 이동 방법에 대한 제한이 없다.
		
		// N 이 1일 땐 무조건 1
		if(N == 1) {
			ans = 1;
		}
		else {
			if(M <= 7) {
				// N 이 2일 때
				// 최대 3번 움직일 수 있음
				if(N == 2) {
					if(M % 2 == 1) {
						ans = ((M / 2) + 1);
					}
					else {
						ans = (M / 2);
					}
				}
				// 그 외
				// M 이 4일 때까지는 최대 3번 움직임 가능
				else {
					if(M <= 4) {
						ans = M;
					}
					// M 이 7보다 작을 때까지는 최대 4칸
					else if (M < 7){
						ans = 4;
					}
					// M 이 7이 되었을 때 최대 5칸 고정
					else {
						ans = 5;
					}
				}
			}
			// M 이 7일 때까지 4번 움직임 다 써서 최대 5칸 가능
			// 그 이후론 한 열 당 한 칸 씩 이동 가능
			else {
				// N 이 2일 때는 예외
				if(N == 2) {
					ans = 4;
				}
				else {
					ans = 5 + (M - 7);
				}
			}
		}
		
		System.out.println(ans);
	}
}