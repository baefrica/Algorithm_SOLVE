import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			String code = sc.nextLine();
			
			if(code.equals("END")) {
				break;
			}
			
			for(int i = code.length()-1; i >= 0; i--) {
				System.out.print(code.charAt(i));
			}
			
			System.out.println();
		}
	}
}