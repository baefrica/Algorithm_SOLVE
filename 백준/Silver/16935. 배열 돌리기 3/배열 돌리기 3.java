import java.util.Scanner;

public class Main {
	static int[][] tmp;
	static int TMP = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int R = sc.nextInt();
		
		int[][] arr = new int[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		// R 번의 연산을 수행한다.
		for(int r = 0; r < R; r++) {
			int state = sc.nextInt();		// 몇 번 연산인가?
			
			switch(state) {
			// 상하 반전
			case 1 :
				tmp = new int[N][M];
				for(int i = 0; i < N; i++) {
					for(int j = 0; j < M; j++) {
						tmp[i][j] = arr[N-1-i][j];
					}
				}
				break;
			
			// 좌우 반전
			case 2 :
				tmp = new int[N][M];
				for(int i = 0; i < N; i++) {
					for(int j = 0; j < M; j++) {
						tmp[i][j] = arr[i][M-1-j];
					}
				}
				break;
				
			// 오른쪽으로 90도 회전
			// 행과 열의 갯수가 서로 바뀐다
			case 3 :
				tmp = new int[M][N];
				for(int i = 0; i < M; i++) {
					for(int j = 0; j < N; j++) {
						tmp[i][j] = arr[N-1-j][i];
					}
				}
				
				TMP = N;
				N = M;
				M = TMP;
				arr = new int[N][M];
				break;
				
			// 왼쪽으로 90도 회전
			// 행과 열의 갯수가 서로 바뀐다
			case 4 :
				tmp = new int[M][N];
				for(int i = 0; i < M; i++) {
					for(int j = 0; j < N; j++) {
						tmp[i][j] = arr[j][M-1-i];
					}
				}
				
				TMP = N;
				N = M;
				M = TMP;
				arr = new int[N][M];
				break;
				
			case 5 :
				tmp = new int[N][M];
				// 1사분면
				for(int i = 0; i < (N / 2); i++) {
					for(int j = 0; j < (M / 2); j++) {
						tmp[i][j] = arr[i + (N / 2)][j];
					}
				}
				// 2사분면
				for(int i = 0; i < (N / 2); i++) {
					for(int j = (M / 2); j < M; j++) {
						tmp[i][j] = arr[i][j - (M / 2)];
					}
				}
				// 3사분면
				for(int i = (N / 2); i < N; i++) {
					for(int j = (M / 2); j < M; j++) {
						tmp[i][j] = arr[i - (N / 2)][j];
					}
				}
				// 4사분면
				for(int i = (N / 2); i < N; i++) {
					for(int j = 0; j < (M / 2); j++) {
						tmp[i][j] = arr[i][j + (M / 2)];
					}
				}
				break;
				
			case 6 :
				tmp = new int[N][M];
				// 1사분면
				for(int i = 0; i < (N / 2); i++) {
					for(int j = 0; j < (M / 2); j++) {
						tmp[i][j] = arr[i][j + (M / 2)];
					}
				}
				// 2사분면
				for(int i = 0; i < (N / 2); i++) {
					for(int j = (M / 2); j < M; j++) {
						tmp[i][j] = arr[i + (N / 2)][j];
					}
				}
				// 3사분면
				for(int i = (N / 2); i < N; i++) {
					for(int j = (M / 2); j < M; j++) {
						tmp[i][j] = arr[i][j - (M / 2)];
					}
				}
				// 4사분면
				for(int i = (N / 2); i < N; i++) {
					for(int j = 0; j < (M / 2); j++) {
						tmp[i][j] = arr[i - (N / 2)][j];
					}
				}
				break;
			}
			
			// 배열 복사
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					arr[i][j] = tmp[i][j];
				}
			}
		}	// R 개의 연산 끝
			
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}