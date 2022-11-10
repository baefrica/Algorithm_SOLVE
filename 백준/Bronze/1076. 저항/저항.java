import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] colors = { "black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white" };
		
		long res = 0;
		
		String color = sc.next();
		for(int i = 0; i < 10; i++) {
			if(color.equals(colors[i])) {
				res += (i * 10);
				break;
			}
		}
		
		color = sc.next();
		for(int i = 0; i < 10; i++) {
			if(color.equals(colors[i])) {
				res += i;
				break;
			}
		}
		
		color = sc.next();
		for(int i = 0; i < 10; i++) {
			if(color.equals(colors[i])) {
				for(int j = 1; j <= i; j++) {
					res *= 10;
				}
				break;
			}
		}
		
		System.out.println(res);
	}
}