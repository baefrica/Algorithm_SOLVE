import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		String str = sc.next();
		char[] tmp = str.toCharArray();

		for (int i = 0; i < tmp.length; i++) {
			if (tmp[i] == 'C' || tmp[i] == 'A' || tmp[i] == 'M' || tmp[i] == 'B' || tmp[i] == 'R' || tmp[i] == 'I'
					|| tmp[i] == 'D' || tmp[i] == 'G' || tmp[i] == 'E') {
				continue;
			} else {
				sb.append(tmp[i]);
			}
		}
		System.out.println(sb);
	}
}
