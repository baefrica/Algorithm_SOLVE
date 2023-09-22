import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class Node {
	int r, c;

	Node(int r, int c) {
		this.r = r;
		this.c = c;
	}
}

// 풀이방법을 생각해보자..
// 모든 cctv가 갈 수 있는 방법 중 하나는 무조건 선택하게 해야 한다.
public class Main {
	static int N;
	static int M;
	static int[][] map;
	static List<Node> cctvList;
	static int cctvCnt;
	// 방향 : 상 0 -> 우 1 -> 하 2 -> 좌 3
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	// 정답
	static int answer = Integer.MAX_VALUE;

	// 1번(1방) : 4가지, 2번(마주보고2방) : 2가지, 3번(직각2방) : 4가지, 4번(3방) : 4가지, 5번(4방) : 1가지
	static int[] modeCnt = { 0, 4, 2, 4, 4, 1 }; // cctv 번호 별로 mode 갯수
	// cctv 번호 별로 방향 index
	// 1 : 0 + 1 + 2 + 3
	// 2 : 02 + 13
	// 3 : 01 + 12 + 23 + 30
	// 4 : 012 + 123 + 230 + 301
	// 5 : 0123
	static int[][][] mode = { {}, { { 0 }, { 1 }, { 2 }, { 3 } }, { { 0, 2 }, { 1, 3 } },
			{ { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 0 } }, { { 0, 1, 2 }, { 1, 2, 3 }, { 2, 3, 0 }, { 3, 0, 1 } },
			{ { 0, 1, 2, 3 } } };

	// 배열 복사하는 함수
	public static void copyArr(int[][] prevArr, int[][] newArr) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				newArr[i][j] = prevArr[i][j];
			}
		}
	}

	// CCTV가 방향대로 쭉 체크하는 함수
	public static void check(Node curr, int[] nowDir, int[][] map) {
		for (int d = 0; d < nowDir.length; d++) {
			int tmpIdx = 1;

			// 벽을 만나거나 경계를 벗어날 때까지
			while (true) {
				int nr = curr.r + dr[nowDir[d]] * tmpIdx;
				int nc = curr.c + dc[nowDir[d]] * tmpIdx;

				if (nr < 0 || nc < 0 || nr >= N || nc >= M) {
					break;
				}
				if (map[nr][nc] == 6) {
					break;
				}

				// 빈 칸인 경우에만..(또다른 CCTV는 뛰어넘어가야한다.)
				if (map[nr][nc] == 0) {
					// 빈 칸을 체크했다고 표시해줌
					map[nr][nc] = 7;
				}
				// 계속 나아가기 위해
				tmpIdx++;
			}
		}
	}

	// DFS 돌면서 CCTV 순서대로 방향 설정해주기
	public static void dfs(int idx, int[][] map) {
		if (idx == cctvCnt) {
			// 사각 지대의 최소 크기 구하기
			int squareArea = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 0) {
						squareArea++;
					}
				}
			}

			answer = Math.min(answer, squareArea);

			return;
		}

		// 맵을 세팅 후 복제함
		int[][] tmpMap = new int[N][M];
		copyArr(map, tmpMap);

		// 현재의 cctv
		Node curr = cctvList.get(idx);
		// cctv 번호의 모드 길이만큼
		for (int i = 0; i < mode[map[curr.r][curr.c]].length; i++) {
			// 현재의 방향 배열은?
			int[] nowDir = mode[map[curr.r][curr.c]][i];

			// 현재의 cctv와 현재의 방향 배열을 가지고 체크를 한다!
			check(curr, nowDir, map);

//			System.out.println("dfs들어가기전 티엠피야 : " + idx);
//			for (int j = 0; j < N; j++) {
//				System.out.println(Arrays.toString(tmpMap[j]));
//			}
//			System.out.println();

			// dfs 돌린다. -> 이 때, map 이 변형되어있음 ㅠㅠ
			dfs(idx + 1, map);

			// 맵 복구해야된다.
//			System.out.println("복구할 맵 : " + idx);
//			for (int j = 0; j < N; j++) {
//				System.out.println(Arrays.toString(tmpMap[j]));
//			}
//			System.out.println();
			copyArr(tmpMap, map);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		cctvList = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();

				// cctv 갯수 카운팅
				if (map[i][j] > 0 && map[i][j] < 6) {
					cctvList.add(new Node(i, j));
				}
			}
		}

		// cctv 총 갯수 구하기
		cctvCnt = cctvList.size();

		dfs(0, map);

		System.out.println(answer);
	}
}
