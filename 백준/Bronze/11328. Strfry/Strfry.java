import java.util.Scanner;
import java.util.StringTokenizer;

/* 
 * strfry 함수 : 입력된 문자열을 무작위로 재배열 -> 새로운 문자열을 만들어냄
 * 입력된 문자열과 새로 재배열된 문자열이 다를 필요는 없다.
 * 2번째 문자열이 1번째 문자열에 strfry 적용하여 얻어질 수 있는지 판단
*/
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 테케 수 (0 < N < 1001)

		/*
		 * sc.nextInt() 후 sc.nextLine() 하기 전에 sc.nextLine() 을 한번 더 작성하여 개행문자 제거
		 */
		sc.nextLine();

		TestCase: for (int tc = 0; tc < N; tc++) {
			StringTokenizer st = new StringTokenizer(sc.nextLine());
			String word1 = st.nextToken(); // 1번째 문자열
			String word2 = st.nextToken(); // 2번째 문자열

			int[] arr = new int[26];
			// 1번째 문자열에 사용된 알파벳 카운팅
			for (int j = 0; j < word1.length(); j++) {
				arr[word1.charAt(j) - 'a']++;
			}

			// 2번째 문자열을 돌면서 확인
			for (int j = 0; j < word2.length(); j++) {
				arr[word2.charAt(j) - 'a']--;
			}

			// 마지막 확인 작업
			for (int j = 0; j < arr.length; j++) {
				if (arr[j] != 0) {
					System.out.println("Impossible");
					continue TestCase;
				}
			}
			System.out.println("Possible");
		}
	}
}