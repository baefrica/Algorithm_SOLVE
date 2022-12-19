import java.util.Scanner;

public class Main {
	static int ansR = 0;
	static int ansC = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int N = sc.nextInt();
		int[][] map = new int[N][N];
		int K = sc.nextInt();
		
		// 상, 하, 좌, 우
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		// ( 0, 0 ) 에서 출발 + 방향은 '하'
		int r = 0;	int c = 0;	int d = 1;
		map[r][c] = (N * N);
		
		while(true) {
			// 기저조건
			// K 좌표 기억하기
			if(map[r][c] == K) {
				ansR = (r + 1);
				ansC = (c + 1);
			}
			// 1까지 입력 끝났으면 종료
			if(map[r][c] == 1) {
				break;
			}
			//
			
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			switch(d) {
			// 내려가다가 부딪치면 우로 변경
			case 1 :
				if(nr >= N || map[nr][nc] != 0) {
					d = 3;
					continue;
				}
			// 우로 가다가 부딪치면 상으로 변경
			case 3 :
				if(nc >= N || map[nr][nc] != 0) {
					d = 0;
					continue;
				}
			// 상으로 가다가 부딪치면 좌로 변경
			case 0 :
				if(nr < 0 || map[nr][nc] != 0) {
					d = 2;
					continue;
				}
			// 좌로 가다가 부딪치면 하로 변경
			case 2 :
				if(nc < 0 || map[nr][nc] != 0) {
					d = 1;
					continue;
				}
			}	// switch 문 끝
			
			// 배열에 채우기
			map[nr][nc] = (map[r][c] - 1);
			
			// r 과 c 에 이전 배열 숫자정보 저장
			r = nr;	c = nc;
		}
		
		// 출력
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				sb.append(map[i][j] + " ");
			}
			sb.append("\n");
		}
		sb.append(ansR + " " + ansC);
		
		System.out.println(sb);
	}
}
