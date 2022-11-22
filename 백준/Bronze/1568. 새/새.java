import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int sum = 0;
		int k = 1;					//	노래부를 숫자 오름차순할 것
		int cnt = 0;				// 1초 지날 때마다 카운팅
		while(true) {
			cnt++;
			sum += k;
			
			// 합이 N 보다 크면 새가 다 날아갔다
			if(sum >= N) {
				break;
			}
			// 노래부를 숫자 오름차순
			else {
				k++;
				
				// 현재 나무에 앉아있는 새의 수가 지금 불러야 하는 수 보다 작을 때는,
				// 1부터 게임을 다시 시작한다.
				if(k > (N - sum)) {
					k = 1;
					continue;
				}
				
			}
		}
		
		System.out.println(cnt);
	}
}