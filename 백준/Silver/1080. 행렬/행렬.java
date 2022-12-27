import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[][] A;
	static int[][] B;
	
	// changeMap
	public static void changeMap(int idx, int jdx) {
		for(int i = idx; i < (idx + 3); i++) {
			for(int j = jdx; j < (jdx + 3); j++) {
				A[i][j] ^= 1;
			}
		}
	}
	
	// main
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 배열 A 입력받는다
		A = new int[N][M];
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < M; j++) {
				A[i][j] = str.charAt(j) - '0';
			}
		}
		// 배열 B 입력받는다
		B = new int[N][M];
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < M; j++) {
				B[i][j] = str.charAt(j) - '0';
			}
		}
		
		int cnt = 0;
		
		// N, M 이 3보다 작은 경우에는 Loop 안으로 못들어간다
		if( Arrays.deepEquals(A, B) ) {
			System.out.println(cnt);
		}
		
		Loop :
		for(int i = 0; i < (N - 2); i++) {
			for(int j = 0; j < (M - 2); j++) {
				if(A[i][j] != B[i][j]) {
					changeMap(i, j);
					cnt++;
				}
				// 배열 A, B 같나?
				if( Arrays.deepEquals(A, B) ) {
					System.out.println(cnt);
					break Loop;
				}
			}
		}
		
		if( !Arrays.deepEquals(A, B) ) {
			System.out.println(-1);
		}
	}
}
