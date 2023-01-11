import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		// M 은 N 보다 작거나 같다
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		boolean[] check = new boolean[N+1];
		check[0] = check[1] = true;
		int sum = 0;
		
		// 에라토스테네스의 체 : 소수를 찾으면서 그 수의 배수들을 다 없앤다
		for(int i = 2; i <= N; i++) {
			if(check[i]) {
				continue;
			}
			// false 이고 범위 내에 속하면 출력
			else {
				if(i >= M) {
					sum += i;
				}
			}
			
			// 1을 제외한 약수가 존재하면 true 로 바꾼다
			for(int j = (i * 2); j <= N; j += i) {
				check[j] = true;
			}
		}
		
		if(sum == 0) {
			sb.append(-1);
		}
		else {
			sb.append(sum).append("\n");
			
			for(int i = M; i <= N; i++) {
				if(!check[i]) {
					sb.append(i);
					break;
				}
			}
		}
		
		System.out.println(sb);
	}
}