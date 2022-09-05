import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int hour = sc.nextInt();
		int minute = sc.nextInt();
		int plus = sc.nextInt();
		
		int mAns = 0;
		mAns = (minute + plus);
		
		int hAns = 0;
		hAns = hour + (mAns / 60);
		
		if(mAns > 59) {
			mAns %= 60;
			
			if(hAns > 23) {
				hAns %= 24;
			}
		}
		
		System.out.println(hAns + " " + mAns);
	}
}