import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 가로, 세로 길이 입력
		int c = sc.nextInt();
		int r = sc.nextInt();
		// 상점 갯수
		int m = sc.nextInt();
		// 상점정보 배열
		int[][] store = new int[m][2];
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < 2; j++) {
				store[i][j] = sc.nextInt();
			}
		}
		
		// 전체둘레길이
		int cir = 2 * (c + r);
		
		// 동근이 위치정보
		int[] dong = new int[2];
		for(int i = 0; i < 2; i++) {
			dong[i] = sc.nextInt();
		}
		
		// 원점으로부터 동근이의 거리
		int dd = 0;
		switch (dong[0]) {
		case 1 :
			dd = dong[1];
			break;
		case 2 :
			dd = (2 * c) + r - dong[1];
			break;
		case 3 :
			dd = cir - dong[1];
			break;
		case 4 :
			dd = c + dong[1];
			break;
		}
		
		// 각 최솟값을 계속 더해줄 합계 sum
		int sum = 0;
		
		// 원점으로부터 상점의 거리 계산
		for(int i = 0; i < m; i++) {
			int min = 0;
			int ds = 0;
			// 1 : 북, 2 : 남, 3: 서, 4 : 동
			switch (store[i][0]) {
			case 1 :
				ds = store[i][1];
				break;
			case 2 :
				ds = (2 * c) + r - store[i][1];
				break;
			case 3 :
				ds = cir - store[i][1];
				break;
			case 4 :
				ds = c + store[i][1];
				break;
			}
			// 동근이와 상점의 거리 중 최솟값
			min = Math.min(Math.abs(dd - ds), cir - Math.abs(dd - ds));
			sum += min;
		}
		
		System.out.println(sum);
	}
}