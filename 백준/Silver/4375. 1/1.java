import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNextInt()) {
			int n = sc.nextInt();
			
			// 1로만 이루어진 n 의 배수 찾기
			// 1, 11, 111, 1111, ...
			// 1 = 1
			// 11 = 1 * 10 + 1
			// 111 = 11 * 10 + 1
			int sum = 0;
			int k = 1;
			while(true) {
				sum = (sum * 10) % n + 1;
				// 큰 수를 대비해 미리 나머지를 구한다
				// 나머지 성질
				// (A + B) % C = ( (A % C) + (B % C) ) % C
				// (A * B) % C = ( (A % C) * (B % C) ) % C
//				sum %= n;
				
				// n 의 배수이면
				if(sum % n == 0) {
					// 1로 이루어진 n 의 배수 중 가장 작은 수의 자릿수를 출력
					System.out.println(k);
					break;
				}
				else {
					k++;
				}
			}	// 작은 while 문 끝
		}	// 큰 while 문 끝
	}
}

//# input :
//3
//7
//9901

//# output :
//3
//6
//12
