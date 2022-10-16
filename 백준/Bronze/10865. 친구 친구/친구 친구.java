import java.util.Scanner;

// 인접 행렬을 만들면 메모리 초과가 남
// 인접 리스트 만들면 시간 초과가 남
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[] friend = new int[N+1];
		
		// 간선을 입력 받는다
		for(int i = 0; i < M; i++) {
			int st = sc.nextInt();
			int ed = sc.nextInt();
			
			// 나의 친구 수를 ++ 해준다
			// 상대의 친구 수도 ++ 해준다
			friend[st]++;
			friend[ed]++;
		}
		
		for(int i = 1; i <= N; i++) {
			System.out.println(friend[i]);
		}
	}
}