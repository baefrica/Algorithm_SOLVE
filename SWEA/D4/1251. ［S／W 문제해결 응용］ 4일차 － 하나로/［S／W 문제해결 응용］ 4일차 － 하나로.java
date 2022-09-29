import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution {
	static int[] x;		// x 좌표
	static int[] y;		// y 좌표
	
	static int[] p;
	
	// make-set
	private static void makeSet(int x) {
		p[x] = x;
	}
	
	// find-set
	private static int findSet(int x) {
		if (x != p[x]) {
			p[x] = (int) findSet(p[x]);
		}
		
		return p[x];
	}
	
	// union
	private static void union(int px, int py) {
		p[findSet(py)] = findSet(px);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1;
		StringTokenizer st2;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int C = 1; C <= T; C++) {
			int N = Integer.parseInt(br.readLine());		// 섬의 갯수 = 정점의 갯수
			st1 = new StringTokenizer(br.readLine());
			st2 = new StringTokenizer(br.readLine());
			
			x = new int[N];
			y = new int[N];
			for(int i = 0; i < N; i++) {
				x[i] = Integer.parseInt(st1.nextToken());
				y[i] = Integer.parseInt(st2.nextToken());
			}
			
			double E = Double.parseDouble(br.readLine());
			
			// 간선의 배열을 저장하기 위한 배열이야
			double[][] edges = new double[N * (N-1) / 2][3];
			int k = 0;
			
			for (int i = 0; i < N-1; i++) {
                for (int j = i+1; j < N; j++) {
                	double xDiff = (x[i] - x[j]);
                	double yDiff = (y[i] - y[j]);
                	
                    edges[k][0] = i;
            		edges[k][1] = j;
    				edges[k][2] = ((xDiff * xDiff) + (yDiff * yDiff)) * E;
    				
                    k++;
                }
            }
			
			// 오름차순 정렬 : 크루스칼에서 제일 먼저 해줄 작업
			Arrays.sort	(edges, new Comparator<double[]>() {
					// 음수냐 양수 혹은 0이냐에 따라 값을 바꿀지 말지 결정을 한다.
					@Override
					public int compare(double[] o1, double[] o2) {
						if (o1[2] >= o2[2])
							return 1;
						else
							return -1;
					}
			});
			
//			for(double[] i : edges)
//				System.out.println(Arrays.toString(i));
			
			p = new int[N];
			
			// make-set 을 해야겠다 (자기 자신을 대표로 초기화 하자)
			for (int i = 0; i < N; i++) {
				makeSet(i);
			}
			
			double ans = 0;		// 정답을 뽑아내기 위한 값
			int pick = 0;		// 간선을 뽑은 갯수
			
			// mst 를 만들기 위해서 간선을 선택하자.
			// 간선의 갯수만큼 본다.
			for (int i = 0; i < (N * (N-1) / 2); i++) {
				// i 번째 간선을 뽑아서 두 정점의 대표를 확인한다.
				int px = findSet((int) edges[i][0]);
				int py = findSet((int) edges[i][1]);
				
				// 대표가 다르다면 union+ (ans 추가 / pick 추가) / 같다면 pass
				if (px != py) {
					union(px, py);
					// 뽑은 간선의 가중치를 합해준다.
					ans += edges[i][2];
					// 뽑았으면 세준다.
					pick++;
				}
				
				// 간선은 (N - 1) 개를 뽑는 순간 멈춘다.
				if (pick == (N - 1)) {
					break;
				}
			}
			
			System.out.println("#" + C + " " + Math.round(ans));
		}	// 테케 끝
	}
}
