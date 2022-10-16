import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int N;
	static List<Integer>[] adjList;
	static boolean[] visited;
	
	// dfs
	public static void dfs(int n) {
		// 방문했으면 돌아가
		if(visited[n]) {
			return;
		}
		// 방문처리 해준다
		visited[n] = true;
		
		// 방문 안한 시작점의 리스트를 돈다
		// 방문안했으면 dfs 재귀처리
		for(int i : adjList[n]) {
			if(!visited[i]) {
				dfs(i);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();		// 정점의 개수
		int M = sc.nextInt();		// 간선의 개수
		
		// 인접 리스트 만들기
		adjList = new ArrayList[N+1];
		
		for(int i = 0; i <= N; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		// 간선을 입력 받는다 -> 인접 리스트 완성됨
		for(int i = 0; i < M; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			
			adjList[u].add(v);
			adjList[v].add(u);
		}
		
		visited = new boolean[N+1];
		
		// 확인용 ㅋㅋ
//		for(int i = 0; i < N+1; i++) {
//			System.out.println(adjList[i]);
//		}
		
		int cnt = 0;
		// 모든 정점을 시작으로 살펴본다
		for(int i = 1; i <= N; i++) {
			// 시작점이 방문했으면 바로 패스
			// 방문안했으면 dfs 시작
			if(!visited[i]) {
				dfs(i);
				// dfs 한 턴 끝나면 카운팅
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
}