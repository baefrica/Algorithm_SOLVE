import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			StringBuilder sb = new StringBuilder();
			System.out.print("#" + t + " ");
			
			String date = sc.next();
			
			String year = "";
			for(int i = 0; i < 4; i++) {
				year += date.charAt(i);
			}
			sb.append(year);
			
			// 월과 일은 범위가 있음
			boolean flag = true;
			
			// 월 판별하기
			String mon = "";
			for(int i = 4; i < 6; i++) {
				mon += date.charAt(i);
			}
			int month = Integer.parseInt(mon);
			if(month >= 1 && month <= 12) {
				sb.append("/" + mon);
			}
			else {
				flag = false;
			}
			
			// 일 판별하기
			String da = "";
			for(int i = 6; i <= 7; i++) {
				da += date.charAt(i);
			}
			int day = Integer.parseInt(da);
			
			switch (month) {
			case 1 : case 3 : case 5 : case 7 : case 8 : case 10 : case 12 :
				if(day >= 1 && day <= 31) {
					sb.append("/" + da);
				}
				else {
					flag = false;
				}
				break;
				
			case 4 : case 6 : case 9 : case 11 :
				if(day >= 1 && day <= 30) {
					sb.append("/" + day);
				}
				else {
					flag = false;
				}
				break;
			
			case 2 :
				if(day >= 1 && day <= 28) {
					sb.append("/" + day);
				}
				else {
					flag = false;
				}
				break;
		}
			
			if(flag == true) {
				System.out.println(sb);
			}
			else {
				System.out.println(-1);
			}
		}
	}
}