import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, M, V;
	static List<Integer>[] list;
	static boolean[] visited;
	
	// DFS
	public static void DFS(int v) {
		System.out.print(v + " ");
		
		if(visited[v]) {
			return;
		}
		// 방문처리
		visited[v] = true;
		
		for(int i : list[v]) {
			if(!visited[i]) {
				DFS(i);
			}
		}
	}	// DFS 끝
	
	// BFS
	public static void BFS(int v) {
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(v);
		visited[v] = true;
		
		while(!queue.isEmpty()) {
			int n = queue.poll();
			System.out.print(n + " ");
			
			for(int i : list[n]) {
				if(!visited[i]) {
					queue.add(i);
					visited[i] = true;
				}
			}
		}	// while 끝
	}	// BFS 끝
		
	// main
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();		// 정점
		M = sc.nextInt();		// 간선
		V = sc.nextInt();		// 탐색을 시작할 정점의 번호
		
		list = new ArrayList[N+1];
		for(int i = 0; i < N+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			int st = sc.nextInt();
			int ed = sc.nextInt();
			
			list[st].add(ed);
			list[ed].add(st);
		}
		
		// 오름차순으로 정렬하기
		// 그래야 정점 번호가 작은 것을 먼저 방문할 수 있다 !!
		for(int i = 0; i < N+1; i++) {
			// 리스트를 오름차순 정렬할 때는..
			Collections.sort(list[i]);
		}
		
		// 확인용 ㅋ.ㅋ
//		for(int i = 0; i < N+1; i++) {
//			System.out.println(list[i]);
//		}
		
		visited = new boolean[N+1];
		// 시작 정점번호부터 DFS
		DFS(V);
		
		System.out.println();
		
		visited = new boolean[N+1];
		// 시작 정점번호부터 DFS
		BFS(V);
	}	// main 끝
}