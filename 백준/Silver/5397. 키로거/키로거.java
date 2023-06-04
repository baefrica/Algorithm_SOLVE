import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			/*
			 * '-' : 백스페이스 '>', '<' : 화살표의 입력
			 */
			String pw = br.readLine();
			List<Character> list = new LinkedList<>();
			// ListIterator 사용법 주의 !!!
			ListIterator<Character> cursor = list.listIterator();
			StringBuilder sb = new StringBuilder();

			// 입력된 것을 다 돌아본다..
			for (int i = 0; i < pw.length(); i++) {
				switch (pw.charAt(i)) {
				case '-':
					if (cursor.hasPrevious()) {
						cursor.previous();
						cursor.remove();
					}
					break;

				case '<':
					if (cursor.hasPrevious()) {
						cursor.previous();
					}
					break;

				case '>':
					if (cursor.hasNext()) {
						cursor.next();
					}
					break;

				default:
					cursor.add(pw.charAt(i));
					break;
				} // switch문 끝
			} // 입력된 것을 다 돌아보는 for문 끝

			// 출력
			for (Character c : list) {
				sb.append(c);
			}
			System.out.println(sb);
		}
	}
}