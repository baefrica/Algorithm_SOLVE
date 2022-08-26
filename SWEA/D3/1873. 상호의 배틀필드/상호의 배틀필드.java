import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			System.out.print("#" + tc + " ");
			
			int H = sc.nextInt();
			int W = sc.nextInt();
			
			char[][] map = new char[H][W];
			
			// 맵 입력받기
			for(int i = 0; i < H; i++) {
				String command = sc.next();
				for(int j = 0; j < W; j++) {
					map[i][j] = command.charAt(j);
				}
			}
			
			// 입력갯수
			int N = sc.nextInt();
			// 입력값 받기
			String input = sc.next();
			
			// 시작하는 땅 찾기
			// row col 은 탱크의 좌표
			int row = 0;
			int col = 0;
			// 방향값을 찾기 위한 d
			int d = 0;
			
			Loop1 : 
			for(int i = 0; i < H; i++) {
				for(int j = 0; j < W; j++) {
					switch(map[i][j]) {
					// 위
					case '^' :
						row = i; col = j;
						d = 0;
						break Loop1;
					// 아래
					case 'v' :
						row = i; col = j;
						d = 1;
						break Loop1;
					// 왼
					case '<' :
						row = i; col = j;
						d = 2;
						break Loop1;
					// 오
					case '>' :
						row = i; col = j;
						d = 3;
						break Loop1;
						
					default :
						break;	
					}
				}
			}
			
			// 명령 받았을 때 수행할 작업
			int[] dr = {-1, 1, 0, 0};
			int[] dc = {0, 0, -1, 1};
			int nr = 0;
			int nc = 0;
			
			for(int i = 0; i < N; i++) {
				switch(input.charAt(i)) {
				case 'U' :
					d = 0;
					if(row == 0) {
						break;
					}
					
					// 평지라면 이동
					if(map[row-1][col] == '.') {
						map[row][col] = '.';
						row--;
					}
					break;
					
				case 'D' :
					d = 1;
					if(row == (H - 1)) {
						break;
					}
					
					// 평지라면 이동
					if(map[row+1][col] == '.') {
						map[row][col] = '.';
						row++;
					}
					break;
					
				case 'L' :
					d = 2;
					if(col == 0) {
						break;
					}
					
					// 평지라면 이동
					if(map[row][col-1] == '.') {
						map[row][col] = '.';
						col--;
					}
					break;
					
				case 'R' :
					d = 3;
					if(col == (W - 1)) {
						break;
					}
					
					// 평지라면 이동
					if(map[row][col+1] == '.') {
						map[row][col] = '.';
						col++;
					}
					break;
					
				case 'S' :
					nr = row + dr[d];
					nc = col + dc[d];
					
					while(true) {
						if(nr < 0 || nc < 0 || nr >= H || nc >= W) {
							break;
						}
						
						// 벽돌 만났을 때
						if(map[nr][nc] == '*') {
							map[nr][nc] = '.';
							break;
						}
						// 강철 벽 만났을 때
						else if(map[nr][nc] == '#') {
							break;
						}
						// 평지이거나 물일 때 다음칸으로 계속 벽 만날 때까지 쏴줘야 함
						else {
							nr = nr + dr[d];
							nc = nc + dc[d];
						}
					}
					break;
				}
			}	// 커맨더 싹다 실행 끝남
			
			switch(d) {
			case 0 :
				map[row][col] = '^';
				break;
				
			case 1 :
				map[row][col] = 'v';
				break;
				
			case 2 :
				map[row][col] = '<';
				break;
				
			case 3 :
				map[row][col] = '>';
				break;
			}
			
			for(int i = 0; i < H; i++) {
				for(int j = 0; j < W; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}	// 테스트케이스 끝
	}
}