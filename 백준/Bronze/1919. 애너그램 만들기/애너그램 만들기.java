import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String word1 = sc.next();
		String word2 = sc.next();

		int[] arr = new int[26];

		// word1 카운팅
		for (int i = 0; i < word1.length(); i++) {
			arr[word1.charAt(i) - 'a']++;
		}

		// word2 돌면서 --
		// 결국 0이 아닌만큼 다 제거해줘야 한다
		for (int i = 0; i < word2.length(); i++) {
			arr[word2.charAt(i) - 'a']--;
		}
		int cnt = 0;
		for (int i = 0; i < arr.length; i++) {
			cnt += Math.abs(arr[i]);
		}

		System.out.println(cnt);
	}
}
