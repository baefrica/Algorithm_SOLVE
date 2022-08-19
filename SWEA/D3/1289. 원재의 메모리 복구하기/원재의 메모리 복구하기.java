import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 테스트케이스 입력 받는다
		int T = sc.nextInt();
		
		for(int x = 1; x <= T; x++) {
			// 메모리를 스트링으로 입력 받는다
			String mem = sc.next();
			// 메모리를 쪼개서 하나하나 넣어줄, 메모리의 길이 크기의 캐릭배열을 생성한다
			char[] arr = new char[mem.length()];
			
			// 메모리를 쪼개서 하나하나 배열에 넣는다
			for(int i = 0; i < mem.length(); i++) {
				arr[i] = mem.charAt(i);
			}
			
			// 홀수번째는 1을 탐색, 짝수번째는 0 이렇게 번갈아 탐색
			int tr = 1;
			// 수정 횟수 세기
			int cnt = 0;
			
			// 배열의 크기만큼
			for(int i = 0; i < arr.length; i++) {
				// 홀수번째는 1을 탐색
				if(tr % 2 == 1) {
					// 1일 때 수정한번, 그리고 다음 반복으로 넘어감
					if(arr[i] == '1') {
						cnt++;
						tr++;
						continue;
					}
				}
				else {
					// 0일 때 수정한번, 그리고 다음 반복으로 넘어감
					if(arr[i] == '0') {
						cnt++;
						tr++;
						continue;
					}
				}
			}
			System.out.println("#" + x + " " + cnt);
		}
	}
}	