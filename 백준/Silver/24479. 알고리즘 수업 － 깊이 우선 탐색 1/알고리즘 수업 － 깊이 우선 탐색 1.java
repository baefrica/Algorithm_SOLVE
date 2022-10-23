import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int N;		// 정점의 수
	static int M;		// 간선의 수
	static int R;		// 시작 정점
	static int[] seq;	// 순서 찾기 배열
	static List<Integer>[] Edges;	// 간선 집합
	static int cnt = 0;
	
	// dfs
	public static void dfs(int v) {
		cnt++;
		seq[v] = cnt;
		
		for(int i : Edges[v]) {
			if(seq[i] == 0) {
				dfs(i);
			}
		}
	}
	
	// main
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		R = sc.nextInt();
		
		Edges = new ArrayList[N+1];
		for(int i = 1; i <= N; i++) {
			Edges[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			
			Edges[u].add(v);
			Edges[v].add(u);
		}
		
		// 각 리스트를 오름차순 정렬
		for(int i = 1; i <= N; i++) {
			Collections.sort(Edges[i]);
		}
		
		seq = new int[N+1];
		dfs(R);
		
		for(int i = 1; i <= N; i++) {
			System.out.println(seq[i]);
		}
	}
}