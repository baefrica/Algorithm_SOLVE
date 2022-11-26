import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next() + "00";
		
		boolean isPikachu = true;
		
		for(int i = 0; i < (str.length() - 2); i++) {
			if(str.charAt(i) == 'p' && str.charAt(i+1) == 'i') {
				i++;
			}
			else if(str.charAt(i) == 'k' && str.charAt(i+1) == 'a') {
				i++;
			}
			else if(str.charAt(i) == 'c' && str.charAt(i+1) == 'h' && str.charAt(i+2) == 'u') {
				i += 2;
			}
			else {
				System.out.println("NO");
				isPikachu = false;
				break;
			}
		}
		
		if(isPikachu) {
			System.out.println("YES");
		}
	}
}