import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		String S = sc.next();
		int[] cnt = new int[5];
		
		for(int i = 0; i < N; i++) {
			switch(S.charAt(i)) {
			case 'H' :
				cnt[0]++;
				break;
				
			case 'I' :
				cnt[1]++;
				break;
				
			case 'A' :
				cnt[2]++;
				break;
				
			case 'R' :
				cnt[3]++;
				break;
				
			case 'C' :
				cnt[4]++;
				break;
			}
		}
		
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < 5; i++) {
			min = Math.min(min, cnt[i]);
		}
		
		System.out.println(min);
	}
}