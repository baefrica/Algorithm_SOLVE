import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[] data = new int[9];
	static int[] sel = new int[7];
	static boolean flag = true;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		for(int i = 0; i < 9; i++) {
		data[i] = sc.nextInt();
		}
		
		// data  배열의 인덱스
		int idx = 0;
		// sel 배열의 인덱스
		int sidx = 0;
		comb(idx, sidx);
	}
	
	public static void comb(int idx, int sidx) {
		// 하나 뽑으면 그만해야해서
		if(flag == true) {
			// 7명 다 뽑으면
			if(sidx == 7) {
				int sum = 0;
				
				// 합을 구한다
				for(int i = 0; i < 7; i++) {
					sum += sel[i];
				}
				
				//합이 100이면 오름차순 정렬해서 출력한다
				if(sum == 100) {
					flag = false;
					Arrays.sort(sel);
					
					for(int i = 0; i < 7; i++) {
						System.out.println(sel[i]);
					}
					return;
				}
				else {
					return;
				}
			}
			
			// data 배열 끝까지 돌았으면 그만
			if(idx == 9) {
				return;
			}
			
			// 조합
			sel[sidx] = data[idx];
			comb(idx+1, sidx+1);
			comb(idx+1, sidx);
		}
	}
}