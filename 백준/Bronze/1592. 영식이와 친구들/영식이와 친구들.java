import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 사람 수 (3 이상 50 이하)
		int N = sc.nextInt();
		// 한 사람이 공을 M번 받으면 끝난다 (50 이하)
		int M = sc.nextInt();
		// 받은 횟수가 홀수이면 시계방향, 짝수이면 반시계방향 L번째 있는 사람에게((N - 1) 이하)
		int L = sc.nextInt();
		
		// 공을 받은 횟수를 저장
		int[] cnt = new int[N];
		// 1번은 항상 공을 받고 시작한다
		cnt[0] = 1;
		
		// 공을 누군가가 받을 때마다 sum++
		int sum = 0;
		int i = 0;
		
		boolean flag = true;
		while(flag) {
			// 한 번 받으면 끝내라 하면 공 안던지고 바로 끝낸다
			if(M == 1) {
				break;
			}
			
			// 받은 횟수가 홀수일 때 시계방향으로
			if(cnt[i] % 2 != 0) {
				i += L;
				// 인덱스가 배열 범위 밖으로 나갈 때를 대비해서
				cnt[i %= N]++;
				sum++;
			}
			// 받은 횟수가 짝수일 때 반시계방향으로
			else {
				i -= L;
				i %= N;
				// 인덱스가 음수일 때 처리
				if(i < 0) {
					i += N;
				}
				cnt[i]++;
				sum++;
			}
			
			// M번 받으면 그만
			if(cnt[i] == M) {
				flag = false;
			}
		} // while 문 끝
		
		System.out.println(sum);
	}
}