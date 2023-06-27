import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Building {
	int idx;
	int height;

	Building(int idx, int height) {
		this.idx = idx;
		this.height = height;
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Stack<Building> stack = new Stack<>();
		// 각 옥상이 확인할 수 있는 갯수를 담을 배열
		int[] cnt = new int[N];
		for (int i = N - 1; i >= 0; i--) {
			// 맨 마지막 빌딩 검사할 때
			if (stack.isEmpty()) {
				stack.push(new Building(i + 1, arr[i]));
			}
			// 그다음부터 검사할 때
			else {
				while (true) {
					// 더이상 pop 할 것이 없다면 push 하고 종료
					if (stack.isEmpty()) {
						stack.push(new Building(i + 1, arr[i]));
						break;
					}
					// 현재 빌딩 > top
					if (arr[i] > stack.peek().height) {
						// 카운팅할 때가 중요한 것 같다 -> 내가 pop 하는 거 1개 + 내가 pop 하는 것이 pop 시킨 갯수
						cnt[i] += (1 + cnt[stack.peek().idx - 1]);
						// top 을 제거
						stack.pop();
					}
					// 현재 빌딩 <= top
					else {
						// push 하고 종료
						stack.push(new Building(i + 1, arr[i]));
						break;
					}
				} // while문 끝
			}
		} // for문 끝

		// 출력
		// 설마 long 으로 바꿔야하나...?
		long sum = 0;
		for (int i : cnt) {
			sum += i;
		}
		System.out.println(sum);
	}
}