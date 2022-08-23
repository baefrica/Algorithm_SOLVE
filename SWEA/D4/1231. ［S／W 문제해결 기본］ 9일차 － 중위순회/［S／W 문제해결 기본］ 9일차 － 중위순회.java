import java.util.Scanner;

public class Solution {
	static String[][] arr;
	
	public static void inorder(String[] word) {
		int left = -1, right = -1;
		
		// 왼쪽 자식이 있을 때 = left 값이 있을 때
		if(word.length > 2) {
			left = Integer.parseInt(word[2]);
		}
		// 오른쪽 자식이 있을 때 = right 값이 있을 때
		if(word.length > 3) {
			right = Integer.parseInt(word[3]);
		}
		
		// 자식 노드가 없을 때는 left = -1, right = -1 이 되고 word[1] 출력하고 return
		// left - 1, right - 1 해주는 이유는 left, right 값 찍었을 때 값보다 배열의 인덱스는 항상 1이 작다.
		if(left != -1) {
			inorder(arr[left-1]);
		}
		// 왼쪽 자식이 없으면 여기로 넘어온다
		System.out.print(word[1]);
		if(right != -1) {
			inorder(arr[right-1]);
		}
		// 나를 불렀던 곳으로 돌아간다
		return;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc = 1; tc <= 10; tc++) {
			// 정점의 총 수
			int N = sc.nextInt();
			// 남은 엔터키를 먹게
			sc.nextLine();
			
			arr = new String[N][4];
			
			// 줄별로 받은 걸 공백으로 쪼개서 배열에 넣는다
			for(int n = 0; n < N; n++) {
				arr[n] = sc.nextLine().split(" ");
			}
			
			// 출력하기
			System.out.print("#" + tc + " ");
			inorder(arr[0]);
			System.out.println();
		}
	}
}