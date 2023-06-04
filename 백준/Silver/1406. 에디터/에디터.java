import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// 시간초과가 나서 BufferedReader 사용...
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String str = br.readLine();
		List<Character> list = new LinkedList<>();
		for (int i = 0; i < str.length(); i++) {
			list.add(str.charAt(i));
		}

		int M = Integer.parseInt(br.readLine()); // (1 ≤ M ≤ 500,000)

//		int cursor = list.size();

		// 시간초과 문제를 해결하기 위해서 ListIterator 사용...
		ListIterator<Character> cursor = list.listIterator();
		// 커서의 위치를 맨 끝으로 이동시킨다
		while (cursor.hasNext()) {
			cursor.next();
		}

		for (int i = 0; i < M; i++) {
			String com = br.readLine();
			StringTokenizer st = new StringTokenizer(com);

			switch (st.nextToken()) {
			case "L":
				if (cursor.hasPrevious()) {
					cursor.previous();
				}
				break;

			case "D":
				if (cursor.hasNext()) {
					cursor.next();
				}
				break;

			case "B":
				if (cursor.hasPrevious()) {
					cursor.previous();
					// 커서 위치의 오른쪽을 삭제
					cursor.remove();
				}
				break;

			case "P":
				char tmp = st.nextToken().charAt(0);
				// 커서 위치의 오른쪽에 삽입
				cursor.add(tmp);
				break;
			} // switch문 끝
		} // for문 끝

		// 출력
		// 시간초과를 해결하기 위해서 조회하는 get 메소드 사용 X
		for (Character c : list) {
			sb.append(c);
		}
		System.out.println(sb);
	}
}