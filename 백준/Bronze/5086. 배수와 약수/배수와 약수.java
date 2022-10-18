import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			if(A == 0 && B == 0) {
				break;
			}
			
			// 첫번째 숫자가 두번째 숫자의 약수라면
			if(B % A == 0) {
				System.out.println("factor");
			}
			else if(A % B == 0) {
				System.out.println("multiple");
			}
			else {
				System.out.println("neither");
			}
		}
	}
}
//
//# input :
//8 16
//32 4
//17 5
//0 0
