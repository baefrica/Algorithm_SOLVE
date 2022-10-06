import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		// i = 1 일 때, 경계 넘는 곳까지 보아야해서
		int[][] candy = new int[N+1][M+1];
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= M; j++) {
				// 입력받고
				candy[i][j] = sc.nextInt();
				// 입력받은 값에서 좌, 좌상, 상 중 최댓값을 더해주며 진행한다
				candy[i][j] += Math.max(Math.max(candy[i-1][j], candy[i-1][j-1]), candy[i][j-1]);
			}
		}
		
		System.out.println(candy[N][M]);
	}
}

//# input :
//3 4
//1 2 3 4
//0 0 0 5
//9 8 7 6

//3 3
//1 0 0
//0 1 0
//0 0 1

//4 3
//1 2 3
//6 5 4
//7 8 9
//12 11 10

//# output :
//31
//
//3
//
//47
