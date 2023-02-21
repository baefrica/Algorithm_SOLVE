import java.util.Scanner;

public class Main {
	static int cnt = 0;

	public static int recursion(String str, int left, int right) {
		if (left >= right) {
			return 1;
		} else if (str.charAt(left) != str.charAt(right)) {
			return 0;
		} else {
			cnt++;	// 재귀를 부를 때마다 카운팅
			return recursion(str, left + 1, right - 1);
		}
	}

	public static int isPalindrome(String str) {
		cnt++;	// 재귀를 부를 때마다 카운팅
		return recursion(str, 0, str.length() - 1);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			String S = sc.next();
			cnt = 0;

			System.out.println(isPalindrome(S) + " " + cnt);
		}
	}
}

//5
//AAA
//ABBA
//ABABA
//ABCA
//PALINDROME
