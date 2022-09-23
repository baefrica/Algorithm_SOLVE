import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	static int N;
	static char[][] map;	// 지도임
	static int ans;	// 총 단지수
	static int cnt;	// 집의 수 카운팅
	static ArrayList<Integer> homeCnt = new ArrayList<Integer>();	// 단지마다 집의 수 저장하기 위한 리스트

	// 시계방향으로 4방 탐색 (상 우 하 좌)
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	// dfs
	public static void dfs(int r, int c) {
		// 집을 없앤다. 안헷갈리게
		map[r][c] = '0';
		// 이 단지의 집의 수를 카운팅
		cnt++;
		// 4방탐색
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			// 넘기는 조건들
			if(nr < 0 || nc < 0 || nr >= N || nc >= N) {
                continue;
            }
			if(map[nr][nc] == '0') {
                continue;
            }	//
			
			dfs(nr, nc);
		}
	}
	
	// main
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		map = new char[N][N];
		for(int i = 0; i < N; i++) {
			String line = sc.next();
			for(int j = 0; j < N; j++) {
				map[i][j] = line.charAt(j);
			}
		}
		
		ans = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				// 집이 있다면
				if(map[i][j] == '1') {
					ans++;	// 총 단지 수 하나 카운팅
					cnt = 0;	// 새로운 단지로 들어왔으니까 집의 수는 리셋
					dfs(i, j);	// 탐색시작
					homeCnt.add(cnt);	// 탐색이 끝났으면 조사한 집의 수를 저장
				}
			}
		}
		// 리스트 오름차순 정렬
		Collections.sort(homeCnt);
		// 이건 총 단지 수 출력
		System.out.println(ans);
		// 리스트 값 순서대로 출력
		for(int i = 0; i < homeCnt.size(); i++) {
			System.out.println(homeCnt.get(i));
		}
	}
}