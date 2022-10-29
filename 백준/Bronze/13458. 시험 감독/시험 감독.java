import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();		// 시험장의 갯수
		
		int[] A = new int[N];		// 각 시험장에 있는 응시자의 수
		for(int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}
		
		int B = sc.nextInt();		// 총감독관이 한 시험장에서 감시할 수 있는 응시자의 수
		int C = sc.nextInt();		// 부감독관이 한 시험장에서 감시할 수 있는 응시자의 수
	
		// 각 시험장마다 총감독관 한명 씩 배치한다
		// 감독관 엄~~~~청 많이 필요할 수도 있따 ㅠ
		long cnt = N;
		
		// 각 시험장을 차례대로 돌껀데
		// 일단 총감독이 감시하는 사람수만큼 빼고
		// 나머지를 부감독이 감시하는 사람수로 나누는데
		for(int i = 0; i < N; i++) {
			// 총감독만으로 해결 가능하면 넘어가
			if((A[i] - B) < 0) {
				continue;
			}
			
			// 나머지가 0이면 알맞게 그 부감독 수 만큼 더해주고 !!
			if((A[i] - B) % C == 0) {
				cnt += ((A[i] - B) / C);
			}
			// 나머지가 0이 아니면 부감독 한명 더 추가 !!
			else {
				cnt += ((A[i] - B) / C) + 1;
			}
		}
		
		System.out.println(cnt);
	}
}