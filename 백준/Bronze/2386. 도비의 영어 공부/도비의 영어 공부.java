import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			String str = sc.nextLine();
			
			if(str.equals("#")) {
				break;
			}
			
			int cnt = 0;
			for(int i = 2; i < str.length(); i++) {
				if(str.charAt(i) == str.charAt(0) || (str.charAt(i) - 0) == (str.charAt(0) - 32)) {
					cnt++;
				}
			}
			
			System.out.println(str.charAt(0) + " " + cnt);
		}
	}
}

//# input : 
//g Programming Contest
//n New Zealand
//x This is quite a simple problem.
//#
