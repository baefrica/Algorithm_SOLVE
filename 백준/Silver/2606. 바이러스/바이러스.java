import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int c;
	static int n;
	static boolean[] visited;
	static List<Integer>[] net;
	
	// dfs
	public static void dfs(int c) {
		if(visited[c]) {
			return;
		}
		// 방문처리
		visited[c] = true;
		
		for(int i : net[c]) {
			if(!visited[i]) {
				dfs(i);
			}
		}
	}	// dfs 끝
	
	// main
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		c = sc.nextInt();		// 컴퓨터의 수는 100 이하 (정점)
		n = sc.nextInt();		// 네트워크 상에서 직접 연결되어 있는 컴퓨터 쌍의 수 (간선)

		net = new ArrayList[c+1];
		for(int i = 0; i < c+1; i++) {
			net[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < n; i++) {
			int st = sc.nextInt();
			int ed = sc.nextInt();
			
			net[st].add(ed);
			net[ed].add(st);
		}
		
		visited = new boolean[c+1];
		// 1번 컴퓨터로부터 감염된 걸 찾는다
		dfs(1);
		
		int cnt = 0;
		// 1번 컴을 제외하고 감염된 컴 갯수
		for(int i = 2; i < c+1; i++) {
			if(visited[i]) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}	// main 끝
}