import java.util.Scanner;

public class Solution {
	static int D;		// 보호 필름의 두께 (3 ≤ D ≤ 13)
	static int W;		// 가로크기 (1 ≤ W ≤ 20)
	static int K;		// 합격기준 (1 ≤ K ≤ D)
	static int[][] film;
	static int minCnt;
	
	// 검사
	public static boolean check() {
		// 각 열 별로 돈다
		for(int j = 0; j < W; j++) {
			int cnt = 1;		// 연속 되는 셀의 특성을 센다
			boolean flag = false;		// 합격 못한 열이 발생
			for(int i = 1; i < D; i++) {
				// 전 행과 같다면
				if(film[i][j] == film[i-1][j]) {
					cnt++;
				}
				// 다르면 다시 리셋
				else {
					cnt = 1;
				}
				// 합격 조건에 도달하면
				if(cnt == K) {
					flag = true;
					break;
				}
			}
			// 마지막 행까지 갔는데도 합격 못했다면 check 결과 : false 하고 빠져나옴
			if(!flag) {
				return false;
			}
		}
		// 모든 열을 검사하고 합격했다
		return true;
	}

	public static void DFS(int r, int chemCnt) {
		// 합격했다면 최소횟수로 갱신
		if(check()) {
			minCnt = Math.min(minCnt, chemCnt);
		}
		// 최소횟수로 갱신 못하거나 모든 행 완료
		if(chemCnt > minCnt || r == D) {
			return;
		}
		// 열의 상태 복사해놓을 배열
		int[] copy = new int[W];
		
		for(int i = 0; i < W; i++) {
			copy[i] = film[r][i];
		}
		
		DFS(r+1, chemCnt);
		
		// A로 바꾸기
		for(int i = 0; i < W; i++) {
			film[r][i] = 0;
		}
		// 검사 다시
		DFS(r+1, chemCnt+1);
		
		// B로 바꾸기
		for(int i = 0; i < W; i++) {
			film[r][i] = 1;
		}
		// 검사 다시
		DFS(r+1, chemCnt+1);
		
		// 원상 복귀
		for(int i = 0; i < W; i++) {
			film[r][i] = copy[i];
		}
	}
			
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int x = 1; x <= T; x++) {
			D = sc.nextInt();	// 보호 필름의 두께 (3 ≤ D ≤ 13)
			W = sc.nextInt();	// 가로크기 (1 ≤ W ≤ 20)
			K = sc.nextInt();	// 합격기준 (1 ≤ K ≤ D)
			
			// A : 0	// B : 1
			film = new int[D][W];
			for(int i = 0; i < D; i++) {
				for(int j = 0; j < W; j++) {
					film[i][j] = sc.nextInt();
				}
			}
			
			minCnt = Integer.MAX_VALUE;
			
			DFS(0, 0);
			
			// 출력해야 할 정답은 성능검사를 통과할 수 있는 약품의 최소 투입 횟수이다.
			// 약품을 투입하지 않고도 성능검사를 통과하는 경우에는 0을 출력한다.
			System.out.println("#" + x + " " + minCnt);
		}	// 테케 끝
	}
}