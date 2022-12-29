import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		String current = sc.next();
		String nat = sc.next();
		
		if( current.equals(nat) ) {
			System.out.println("24:00:00");
			System.exit(0);
		}
		
		StringTokenizer st1 = new StringTokenizer(current, ":");
		StringTokenizer st2 = new StringTokenizer(nat, ":");
		
		// hh
		int st1H = Integer.parseInt(st1.nextToken());
		int st2H = Integer.parseInt(st2.nextToken());
		int hh = st2H - st1H;
		
		// mm
		int st1M = Integer.parseInt(st1.nextToken());
		int st2M = Integer.parseInt(st2.nextToken());
		int mm = st2M - st1M;
		
		// ss
		int st1S = Integer.parseInt(st1.nextToken());
		int st2S = Integer.parseInt(st2.nextToken());
		int ss = st2S - st1S;
		
		if(ss < 0) {
			ss += 60;
			mm--;
		}
		if(mm < 0) {
			mm += 60;
			hh--;
		}
		if(hh < 0) {
			hh += 24;
		}
			
		// 출력
		System.out.format("%02d:%02d:%02d", hh, mm, ss);
	}
}
