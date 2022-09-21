import java.util.Scanner;

public class Main {
	static int[][] arr;
	static int N;
	static int cnt;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		arr = new int[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		// 파이프의 위치
		int r1 = 0; int c1 = 0;
		int r2 = 0; int c2 = 1;
		pipeMoving(r1, r2, c1, c2);
		
		System.out.println(cnt);
	}
	
	// 파이프의 상태 체크 함수
	public static void pipeMoving(int r1, int r2, int c1, int c2) {
		if(r2 == N-1 && c2 == N-1) {
			cnt++;
			return;
		}
		else {
			// 가로 상태
			if(r1 == r2) {
				// 아래 경계에 도달하면 오른쪽으로 밖에 못간다
				if(r2 == N-1) {
					// 오른쪽에 벽이 없다면
					if(arr[r2][c2+1] == 0) {
						pipeMoving(r2, r2, c2, c2+1);
					}
				}
				// 오른쪽 경계에 도달하면 갈 곳이 없다
				else if(c2 == N-1) {
					return;
				}
				// 경계에 안도달했을때 (2가지 방법)
				else {
					if(arr[r2][c2+1] == 0 && arr[r2+1][c2+1] == 0 && arr[r2+1][c2] == 0) {
						pipeMoving(r2, r2+1, c2, c2+1);
					}
					if(arr[r2][c2+1] == 0) {
						pipeMoving(r2, r2, c2, c2+1);
					}
				}
			}
			// 세로 상태
			else if(c1 == c2) {
				// 아래 경계에 도달하면 갈 곳이 없다
				if(r2 == N-1) {
					return;
				}
				// 오른쪽 경계에 왔을 때 밑으로는 내려갈수 있음
				else if(c2 == N-1) {
					// 밑에 벽이 없는지 체크
					if(arr[r2+1][c2] == 0) {
						pipeMoving(r2, r2+1, c2, c2);
					}
				}
				// 경계에 안도달했을 때 (2가지 방법)
				else {
					if(arr[r2][c2+1] == 0 && arr[r2+1][c2+1] == 0 && arr[r2+1][c2] == 0) {
						pipeMoving(r2, r2+1, c2, c2+1);
					}
					if(arr[r2+1][c2] == 0) {
						pipeMoving(r2, r2+1, c2, c2);
					}
				}
			}
			// 대각 상태
			else {
				// 아래 경계에 도달하면 오른쪽으로 가로방향으로 갈 수 있다
				if(r2 == N-1) {
					// 오른쪽에 벽이 없는 지 체크
					if(arr[r2][c2+1] == 0) {
						pipeMoving(r2, r2, c2, c2+1);
					}
				}
				// 오른쪽 경계에 있을 때 밑으로는 내려갈수 있음
				else if(c2 == N-1) {
					// 밑에 벽이 없는 지 체크
					if(arr[r2+1][c2] == 0) {
						pipeMoving(r2, r2+1, c2, c2);
					}
				}
				//  경계에 안도달했을 때 (3가지 방법)
				else {
					if(arr[r2][c2+1] == 0) {
						pipeMoving(r2, r2, c2, c2+1);
					}
					if(arr[r2+1][c2] == 0) {
						pipeMoving(r2, r2+1, c2, c2);
					}
					if(arr[r2][c2+1] == 0 && arr[r2+1][c2+1] == 0 && arr[r2+1][c2] == 0) {
						pipeMoving(r2, r2+1, c2, c2+1);
					}
				}
			}
		}
	}
}