import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		sc.nextLine();
		
		for(int tc = 0; tc < T; tc++) {
			StringBuilder sb = new StringBuilder();
			
			String str = sc.nextLine();
			char[] arr = new char[str.length()];
			
			for(int i = 0; i < str.length(); i++) {
				arr[i] = str.charAt(i);
			}
			
			// 글자가 있는 구간
			int start = 0;
			int end = 0;
			
			for(int i = 0; i < str.length(); i++) {
				// 구간의 시작
				start = i;
				i++;
				
				while(true) {
					// 끝칸으로 가면
					if(i == str.length()) {
						// 공백 전까지를 구간의 끝으로
						end = (i - 1);
						for(int j = end; j >= start; j--) {
							sb.append(arr[j]);
						}
						break;
					}
					
					// 공백을 만나면 그 전까지 출력, i는 공백 값의 인덱스에 위치
					if(arr[i] == ' ') {
						// 공백 전까지를 구간의 끝으로
						end = (i - 1);
						for(int j = end; j >= start; j--) {
							sb.append(arr[j]);
						}
						sb.append(" ");
						break;
					}
					// 공백을 안만날 땐 계속 한 칸씩 나아가기
					else {
						i++;
					}
				}	// while문 끝
			}
			System.out.println(sb);
		}	// 테케 끝
	}
}