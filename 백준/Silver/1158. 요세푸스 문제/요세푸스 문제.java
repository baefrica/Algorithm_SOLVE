import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int N = sc.nextInt();
		int K = sc.nextInt();

		List<Integer> list = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			list.add(i);
		}

		sb.append("<");

		int idx = 0;
		int cnt = 0;
		while (true) {
			cnt++;

			if (list.size() == 1) {
				sb.append(list.remove(idx)).append(">");
				break;
			}

			if (cnt == K) {
				sb.append(list.remove(idx)).append(", ");
				cnt = 0;
			} else {
				idx++;
			}

			if (idx >= list.size()) {
				idx = 0;
			}
		}

		System.out.println(sb);
	}
}