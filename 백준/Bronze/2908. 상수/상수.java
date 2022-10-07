import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String A = sc.next();
		String B = sc.next();
		
		for(int i = 2; i >= 0; i--) {
			if(A.charAt(i) > B.charAt(i)) {
				System.out.print(A.charAt(2) + "" + A.charAt(1) + "" + A.charAt(0));
				break;
			}
			else if(A.charAt(i) < B.charAt(i)) {
				System.out.print(B.charAt(2) + "" + B.charAt(1) + "" + B.charAt(0));
				break;
			}
			else {
				continue;
			}
		}
	}
}