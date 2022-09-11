import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			int month1 = sc.nextInt();
			int day1 = sc.nextInt();
			int month2 = sc.nextInt();
			int day2 = sc.nextInt();
			
			// m 이란 변수에 첫번째 달 넣기
			int m = month1;
			int ans = 0;
			
			while(true) {
				int d2 = 0;
				// month2 와 같으면 반복 멈춤
				if(m == month2) {
					ans += (day2 - day1) + 1;
					break;
				}
				// 아니면,,
				else {
					// 그 달의 끝 날짜까지 간다 우선
					switch(m) {
					case 1 : case 3 : case 5 : case 7 : case 8 : case 10 : case 12 :
						d2 = 31;
						break;
					case 4 : case 6 : case 9 : case 11 :
						d2 = 30;
						break;
					case 2 :
						d2 = 28;
						break;
					}
					
					// 끝 날에서 첫 날까지의 날짜수 세기
					ans += (d2 - day1) + 1;
					// 달을 한칸 넘어가자
					m++;
					// 달을 넘겼으니 첫번째 일은 1일로 리셋
					day1 = 1;
				}
			}
			
			System.out.println("#" + t + " " + ans);
		}
	}
}
