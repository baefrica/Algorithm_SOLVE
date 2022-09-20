import java.util.Scanner;

// 클래스
public class Main {
	// 메인 함수
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		chatBot(N);
	}
	
	// 챗봇 함수
	public static void chatBot(int n) {
		System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
		
		// 언더바 카운팅
		int cnt = 0;
		
		for(int i = 0; i <= n; i++) {
			bar(cnt);
			System.out.println("\"재귀함수가 뭔가요?\"");
			
			// n번째 답변 도달하면 진짜 답변하고 마무리까지
			if(i == n) {
				bar(cnt);
				System.out.println("\"재귀함수는 자기 자신을 호출하는 함수라네\"");
				
				// 뭔가요? 만큼 답변 + 언더바는 점점 줄이기
				for(int k = 0; k <= n; k++) {
					bar(cnt);
					System.out.println("라고 답변하였지.");
					cnt--;
				}
			}
			// 계속 썰푸는 답변
			else {
				bar(cnt);
				System.out.println("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.");
				bar(cnt);
				System.out.println("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.");
				bar(cnt);
				System.out.println("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");
			}
			
			// 언더바 카운팅 증가
			cnt++;
		}	// 재귀함수가 뭔가요?
	}	// chatBot() 끝
	
	// 언더바를 출력하는 함수
	public static void bar(int n) {
		for(int i = 0; i < n; i++) {
				System.out.print("____");
		}
	}	// bar() 끝
}	// 클래스 끝