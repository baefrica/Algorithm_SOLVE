import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int idx = 1;
		
		while(true) {
			int n0 = sc.nextInt();
			// 종료
			if(n0 == 0) {
				break;
			}
			
			System.out.print(idx + ". ");
			idx++;
			
			// n1 계산
			int n1 = 3 * n0;
			int n2;
			// n2 계산
			if(n1 % 2 == 0) {
				n2 = n1 / 2;
				System.out.print("even ");
			}
			else {
				n2 = (n1+1) / 2;
				System.out.print("odd ");
			}
			// n3 계산
			int n3 = 3 * n2;
			// n4 계산
			int n4 = n3 / 9;
			System.out.println(n4);
		}
	}
}