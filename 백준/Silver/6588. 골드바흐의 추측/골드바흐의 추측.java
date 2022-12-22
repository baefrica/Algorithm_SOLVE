import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 에라토스테네스의 체로 소수에 false 표시
		boolean[] prime = new boolean[1000001];
		prime[0] = prime[1] = true;
		
		for(int i = 2; i < prime.length; i++) {
			if(prime[i]) {
				continue;
			}
			for(int j = (i + i); j < prime.length; j += i) {
				if(prime[j]) {
					continue;
				}
				prime[j] = true;
			}
		}	// 에라토스테네스의 체 끝
		
		while(true) {
			StringBuilder sb = new StringBuilder();
			
			// 숫자 입력받는다
			int n = sc.nextInt();
			// 종료 조건
			if(n == 0) {
				break;
			}
			else {
				sb.append(n + " = ");
			}
			
			// 정답 a, b
//			int ansA = 1;
//			int ansB = 0;
			boolean isWrong = false;
			// 절반까지만 보면 된다
			for(int i = 3; i <= (n / 2); i += 2) {
				// 둘 다 소수라면 !!
				if(!prime[i] && !prime[n-i]) {
					int a = i;
					int b = (n - i);
					sb.append(a + " + " + b);
					isWrong = true;
					// n 을 만들 수 있는 방법이 여러 가지라면 (b - a) 가 가장 큰 것을 선택
					// 처음 나온 소수가 가장 큰 차이를 만든다 !!
//					if( (b - a) > (ansB - ansA) ) {
//						ansA = a;
//						ansB = b;
//					}
					break;
				}
			}	// for 문 끝
			
			// 소수의 합으로 n 을 나타낼 수 없는 경우
			// "Goldbach's conjecture is wrong."을 출력
			if(!isWrong) {
				System.out.println("Goldbach's conjecture is wrong.");
			}
			else {
				// 출력하기
//				sb.append(ansA + " + " + ansB);
				System.out.println(sb);
			}
		}	// while 문 끝
	}
}
