import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[3];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		if(arr[0] == arr[1] && arr[1] == arr[2]) {
			System.out.println(10000 + (arr[0] * 1000));
		}
		else if(arr[0] == arr[1] && arr[1] != arr[2]) {
			System.out.println(1000 + (arr[0] * 100));
		}
		else if(arr[0] == arr[2] && arr[0] != arr[1]) {
			System.out.println(1000 + (arr[0] * 100));
		}
		else if(arr[1] == arr[2] && arr[1] != arr[0]) {
			System.out.println(1000 + (arr[1] * 100));
		}
		else {
			int max = Integer.MIN_VALUE;
			for(int i = 0; i < arr.length; i++) {
				max = Math.max(arr[i], max);
			}
			System.out.println(max * 100);
		}
	}
}