import java.util.Scanner;

public class Main {
    static int[][] map;
    static int W;
	static int H;
	static int cnt = 0;
	// 8방 탐색 하기 위한 델타 도구
	static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
	
	// main
    public static void main(String[] args) {
    	
        Scanner sc = new Scanner(System.in);
        
        while(true) {
            W = sc.nextInt();
            H = sc.nextInt();
            
            // 0 0 출력되면 종료
            if(W == 0 && H == 0)
                break;
            
            map = new int[H][W];
            for(int i = 0; i < H; i++) {
                for(int j = 0; j < W; j++) {
                    map[i][j] = sc.nextInt();
                }
            }
            
            int cnt = 0;
            // 탐색하면서, 육지인 경우. 카운트를 하나 세고, 연결된 모든 육지를 삭제
            for(int i = 0; i < H; i++) {
                for(int j = 0; j < W; j++) {
                	// 차례대로 가면서 1을 발견했을 때 그 자리에서 
                    if(map[i][j] == 1) {
                    	// 우선은 갯수 하나 센다
                    	cnt++;
                    	//연결된 모든 육지를 0으로 삭제
                        dfs(i, j);
                    }
                }
            }
            
            System.out.println(cnt);
        }	// while 문
    }
    
    // 깊이 우선 탐색
    public static void dfs(int r, int c) {
        // 현재 육지를 삭제
        map[r][c] = 0;
        // 8방 탐색합니다
        for(int d = 0; d < 8; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            // 밖으로 나가면 패스
            if(nr < 0 || nc < 0 || nr >= H || nc >= W) {
                continue;
            }
            // 바다여도 패스
            if(map[nr][nc] == 0) {
                continue;
            }
            // 육지라면 재귀 콜
            dfs(nr, nc);
        }	// 8방이 다 0이면 for 문 끝
    }
}