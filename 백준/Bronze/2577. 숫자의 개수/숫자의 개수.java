import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int res = sc.nextInt() * sc.nextInt() * sc.nextInt();
		
		int[] cnt = new int[10];
		String result = Integer.toString(res);
		
		for(int i = 0; i < result.length(); i++) {
			cnt[result.charAt(i)-48]++;
		}
		for(int i = 0; i < cnt.length; i++) {
			System.out.println(cnt[i]);
		}
	}
}