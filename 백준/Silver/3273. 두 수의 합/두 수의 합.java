import java.util.Scanner;

/*
 * 시간 복잡도를 생각해서
 * O(n²)을 만들면 안된다!
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 입력
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		int x = sc.nextInt();
		
		// tmp 의 범위를 생각해야한다... 
		boolean[] num = new boolean[2000000];
		int cnt = 0;
		for (int i : arr) {
			// tmp 가 음수일 수도 있음
			// 왜? x가 a보다 더 작을 수 있잖아
			int tmp = x - i;

			// tmp 가 내 앞에 있었나? 확인한다.
			// 있었으면? 1쌍 추가
			// 중요 : tmp 가 음수일 수도 있다는 걸 생각한다
			if (tmp > 0 && num[tmp]) {
				cnt++;
			}
			// 숫자의 존재 여부 체크
			num[i] = true;
		}

		System.out.println(cnt);
	}
}