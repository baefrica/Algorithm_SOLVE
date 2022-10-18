import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		boolean[] check = new boolean[31];
		for(int i = 0; i < 28; i++) {
//			int n = sc.nextInt();
			check[sc.nextInt()] = true;	// 과제 냈다고 표시 !
		}
		
		for(int i = 1; i < 31; i++) {
			// 과제 안냈으면
			if(!check[i]) {
				// 번호 출력
				System.out.println(i);
			}
		}
	}
}