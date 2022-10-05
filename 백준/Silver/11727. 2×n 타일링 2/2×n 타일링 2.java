import java.util.Scanner;

public class Main {
	static long[] memo;	// 메모이제이션 배열 생성
			
	public static long tiling(int n) {
		// n 에 대해 계산한 적이 없다면
		if(memo[n] == 0) {
			// tiling(n-1) 에 세로막대 하나 추가
			// tiling(n-2) 에 가로 두 종류 추가
			memo[n] = (tiling(n-1) + (2 * tiling(n-2))) % 10007;
		}
		
		return memo[n];
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();	// (1 ≤ n ≤ 1,000)
		
		memo = new long[n+2];
		memo[1] = 1;
		memo[2] = 3;
		
		// (2 x n) 크기의 직사각형을 채우는 방법의 수를 10,007로 나눈 나머지를 출력
		System.out.println(tiling(n));
	}
}

//# input :
//2
//
//8
//
//12
//
//# output :
//3
//
//171
//
//2731
