import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			String octo = sc.nextLine();
			
			// 종료조건
			if(octo.equals("#")) {
				break;
			}
			
			int ans = 0;
			int num = 0;
			
			for(int i = 0; i < octo.length(); i++) {
				switch(octo.charAt(i)) {
				case '-' :
					num = 0;
					break;
					
				case '\\' :
					num = 1;
					break;
					
				case '(' :
					num = 2;
					break;
					
				case '@' :
					num = 3;
					break;
					
				case '?' :
					num = 4;
					break;
					
				case '>' :
					num = 5;
					break;
					
				case '&' :
					num = 6;
					break;
					
				case '%' :
					num = 7;
					break;
					
				case '/' :
					num = -1;
					break;
				}	// switch 문 끝
				
				for(int j = i; j < (octo.length() - 1); j++) {
					num *= 8;
				}
				
				ans += num;
			}
			System.out.println(ans);
		}	// while 문 끝
	}
}

//# input :
//(@&
//?/--
///(\
//?
//#
