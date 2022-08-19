import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		for(int t = 1; t <= TC; t++) {
			String a = sc.next();
			// 현재의 막대 수
			int currentCnt = 0;
			// 잘려진 전체 조각 수
			int sum = 0;
			
			char[] arr = a.toCharArray();
			
			for(int i = 0; i < arr.length; i++) {
				// 열렸을 때
				if(arr[i] == '(') {
					// 바로 안닫히면 막대 Start
					if(arr[i+1] != ')') {
					// 현재 막대 수에 추가
					currentCnt++;
					}
				}
				// 닫혔을 때
				else {
					// 레이저가 만들어지면
					if(arr[i-1] == '(') {
						// 전체 조각 수에 현재 막대 수를 추가
						sum += currentCnt;
					}
					else {
						// 막대가 끝남을 의미
						currentCnt--;
						// 전체 조각 수에 현재 막대 수를 추가
						sum++;
					}
				}
			}
			
			System.out.println("#" + t + " " + sum);
		}
	}
}