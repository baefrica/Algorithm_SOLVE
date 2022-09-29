import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	static int V;		// 정점의 갯수
	static int E;		// 간선의 갯수
	static int[] p;	// 대표를 저장할 배열

	// make-set
	private static void makeSet(int x) {
		p[x] = x;
	}

	// find-set
	private static int findSet(int x) {
		if (x != p[x]) {
			p[x] = findSet(p[x]);
		}

		return p[x];
	}

	// union
	private static void union(int x, int y) {
		p[findSet(y)] = findSet(x);
	}

	// main (Kruskal's Algorithm)
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		V = sc.nextInt();
		E = sc.nextInt();

		// 간선의 배열을 저장하기 위한 배열이야
		int[][] edges = new int[E][3];
		// 입력
		for (int i = 0; i < E; i++) {
			edges[i][0] = sc.nextInt(); // A : [0] 시작정점
			edges[i][1] = sc.nextInt(); // B : [1] 도착정점
			edges[i][2] = sc.nextInt(); // C : [2] 가중치
		}

		// 오름차순 정렬 : 크루스칼에서 제일 먼저 해줄 작업
		Arrays.sort	(edges, new Comparator<int[]>() {
				// 음수냐 양수 혹은 0이냐에 따라 값을 바꿀지 말지 결정을 한다.
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[2] - o2[2];
				}
		});

		p = new int[V+1];

		// make-set 을 해야겠다 (자기 자신을 대표로 초기화 하자)
		for (int i = 1; i <= V; i++) {
			makeSet(i);
		}

		long ans = 0;	// 정답을 뽑아내기 위한 값
		int pick = 0;		// 간선을 뽑은 갯수

		// mst 를 만들기 위해서 간선을 선택하자.
		// 간선의 갯수만큼 본다.
		for (int i = 0; i < E; i++) {
			// i 번째 간선을 뽑아서 두 정점의 대표를 확인한다.
			int px = findSet(edges[i][0]);
			int py = findSet(edges[i][1]);

			// 대표가 다르다면 union (ans 추가 / pick 추가) / 같다면 pass
			if (px != py) {
				union(px, py);
				// 뽑은 간선의 가중치를 합해준다.
				ans += edges[i][2];
				// 뽑았으면 세준다.
				pick++;
			}

			// 간선은 (V - 1) 개를 뽑는 순간 멈춘다.
			if (pick == (V - 1)) {
				break;
			}
		}
		System.out.println(ans);
	}
}