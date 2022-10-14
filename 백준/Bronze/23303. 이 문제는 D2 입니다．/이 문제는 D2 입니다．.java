import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		
		boolean flag = false;
		for(int i = 0; i < str.length()-1; i++) {
			if((str.charAt(i) == 'D' || str.charAt(i) == 'd') && str.charAt(i+1) == '2') {
				System.out.print("D2");
				flag = true;
				break;
			}
		}
		
		if(flag == false) {
			System.out.print("unrated");
		}
	}
}