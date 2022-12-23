import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 카운팅 정렬하기
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			max = Math.max(arr[i], max);
		}
		
		// 1. max 를 포함하는 카운팅 배열을 생성
		int[] cnt = new int[max+1];
		// 2. 갯수를 카운팅
		for(int i = 0; i < N; i++) {
			cnt[arr[i]]++;
		}
		
		// 3. 누적합 구하기
		for(int i = 1; i < cnt.length; i++) {
			cnt[i] += cnt[i-1];
		}
//		System.out.println("cnt : " + Arrays.toString(cnt));
		
		// 4. arr 과 같은 크기의 tmp 배열 생성
		int[] tmp = new int[N];

		// 5. 뒤부터 읽고
		for(int i = (N - 1); i >= 0; i--) {
			// 카운팅 배열에서 깎으면서
			// tmp 채우기
			tmp[--cnt[arr[i]]] = arr[i];
		}
		
		// 출력하기
		for(int i = 0; i < N; i++) {
			bw.write(tmp[i] + "\n");
		}
		
		br.close();
		
		bw.flush();
		bw.close();
	}
}