import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		StringBuilder sb = new StringBuilder();

		String str = sc.nextLine();
		char[] arr = new char[str.length()];
		
		// 글자들을 배열에 입력
		for(int i = 0; i < str.length(); i++) {
			arr[i] = str.charAt(i);
		}
		
		// 출력할 구간의 시작
		int start = 0;
		// 출력할 구간의 끝
		int end = 0;
		
		for(int i = 0; i < str.length(); i++) {
			// '<' 를 만나면
			if(arr[i] == '<') {
				start = i;
				
				while(true) {
					i++;
					
					// 닫는거 만나면
					if(arr[i] == '>') {
						end = i;
						
						// 괄호포함 사이 구간을 다 출력
						for(int j = start; j <= end; j++) {
							sb.append(arr[j]);
						}
						break;
					}
				}
			}	// 여는 괄호 '<'
			// 괄호 사이가 아닌 경우
			else {
				start = i;
				
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
					// 여는 괄호 만나면 그 전까지 출력하고 i-- 꼭 해줘야 한다 !
					else if(arr[i] == '<') {
						end = (i - 1);
						for(int j = end; j >= start; j--) {
							sb.append(arr[j]);
						}
						// i-- 꼭 해주고 꼭 나가야 한다 -> 그래야 여는 괄호 if 문으로 갈 수 있음
						i--;
						break;
					}
					// 공백을 안만날 땐 계속 한 칸씩 나아가기
					else {
						i++;
					}
				}	// while문 끝
			}
		}
		System.out.println(sb);
	}
}