import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int K = Integer.parseInt(br.readLine());
		for(int i = 0; i < K; i++) {
			sb.append("Class " + (i + 1) + "\n");
			
			// 한 줄 입력받는다
			st = new StringTokenizer(br.readLine());
			
			// i 반의 학생 수
			int N = Integer.parseInt(st.nextToken());
			
			int[] math = new int[N];
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			for(int j = 0; j < N; j++) {
				math[j] = Integer.parseInt(st.nextToken());
				max = Math.max(math[j], max);
				min = Math.min(math[j], min);
			}
			// 최댓값, 최솟값 출력
			sb.append("Max " + max + ", Min " + min + ", ");
			
			// 오름차순 정렬
			Arrays.sort(math);
			
			// 가장 큰 인접한 점수 차이
			int gapMax = Integer.MIN_VALUE;
			for(int m = 0; m < (N - 1); m++) {
				gapMax = Math.max( (math[m+1] - math[m]) , gapMax);
			}
			sb.append("Largest gap " + gapMax + "\n");
		}
		
		System.out.println(sb);
	}
}