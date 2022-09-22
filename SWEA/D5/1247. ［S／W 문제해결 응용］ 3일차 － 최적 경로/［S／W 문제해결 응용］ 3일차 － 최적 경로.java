import java.util.Scanner;

public class Solution {
	static int N;
	static int[] office = new int[2];
	static int[] home = new int[2];
	static int[][] map;	// 고객들의 위치
	static boolean[] visited;	// 방문한 집 체크
	static int sum;	// 한번 배달 갈 때 거리 총합
	static int min;	// 매번 갔을 때 중 최솟값 저장하기
	
	static int[] result;	// 순열 돌려서 순서를 저장할 배열
	static int[] cur = new int[2];	// 현재 내 위치
	static int[] next = new int[2];	// 다음으로 방문할 집 위치
	
	// 거리 계산
	public static int calc(int x1, int y1, int x2, int y2) {
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}
	
	// perm
	public static void perm(int idx) {
		if( idx == N ) {
			// 회사에서 출발해서 map 을 result 의 순서대로 방문해가며 거리를 누적합
			// 방문이 끝날 때마다 합계를 0으로 초기화
			sum = 0;
			
			// 자 회사에서 출발
			cur[0] = office[0];
			cur[1] = office[1];
			
			// result 에 있는 순서가 map 의 행 번호가 되는 것이다
			// 그래서 순서대로 반복문 실행
			for(int i = 0; i < N; i++) {
				// result 순서대로 다음 갈 집을 리셋
				next[0] = map[result[i]][0];
				next[1] = map[result[i]][1];
				
				// 현재 위치와 다음 갈 집 거리 계산해서 더해준다
				sum += calc(next[0], next[1], cur[0], cur[1]);
				
				// 현재의 위치를 옴겨준다
				cur[0] = next[0];
				cur[1] = next[1];
			}
			
			// 다했다면 집가야지
			sum += calc(cur[0], cur[1], home[0], home[1]);
			// 거리의 최소 갱신
			min = Math.min(sum, min);
			return;
		}
		
		// 순열로 인해 result 에 방문할 집들 순서가 담긴다
		for(int i = 0; i < N; i++) {
			if(visited[i]) {
				continue;
			}
			result[idx] = i;
			visited[i] = true;
			perm(idx + 1);
			visited[i] = false;
		}
	}
	
	// main
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int x = 1; x <= T; x++) {
			N = sc.nextInt();
			
			// 회사 위치
			office[0] = sc.nextInt();
			office[1] = sc.nextInt();
			
			// 집의 위치
			home[0] = sc.nextInt();
			home[1] = sc.nextInt();
			
			// 고객의 위치
			map = new int[N][2];
			for(int i = 0; i < N; i++) {
				map[i][0] = sc.nextInt();
				map[i][1] = sc.nextInt();
			}
			
			// 초기화 해줄 것들
			visited = new boolean[N];
			result = new int[N];
			min = Integer.MAX_VALUE;
			
			perm(0);
			System.out.println("#" + x + " " + min);
		}	// 테케 끝
	}
}