import java.util.Scanner;

public class Main {
	/*
	// f(A)
	public static long f(int A) {
		long ans = 0;
		for(int i = 1; i <= A; i++) {
			if(A % i == 0) {
				ans += i;
			}
		}
		
		return ans;
	}
	
	// g(x)
	public static long g(int x) {
		long ans = 0;
		for(int i = 1; i <= x; i++) {
			ans += f(i);
		}
		
		return ans;
	}
	*/
	
	// main
	// n 이하 k 를 약수로 갖는 수의 갯수 = n 이하의 k 의 배수들 = n / k
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		long ans = 0;
		for(int i = 1; i <= N; i++) {
			ans += (N / i) * i;
		}
		
		System.out.println(ans);
	}
}
