import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int change = 1000 - sc.nextInt();	// 거스름돈
		
		// 잔돈 : 500엔, 100엔, 50엔, 10엔, 5엔, 1엔
		int[] arr = {500, 100, 50, 10, 5, 1};
		int cnt = 0;
		
		// 젤 큰 잔돈부터 나누어서 매수 카운팅
		// 남은 돈은 다시 잔돈으로
		for(int i = 0; i < arr.length; i++) {
			cnt += (change / arr[i]);
			change %= arr[i];
			
			// 0원 되면 잔돈 다 나눈거니까 종료
			if(change == 0) {
				break;
			}
		}
		
		System.out.println(cnt);
	}
}

//# input :
//380
//
//1
//
//# output :
//4
//
//15
