import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 스위치 갯수
		int num = sc.nextInt();
		
		// 스위치의 상태
		int[] oArr = new int[num];
		for(int i = 0; i < num; i++) {
			oArr[i] = sc.nextInt();
		}
		
		// 학생 수
		int student = sc.nextInt();
		
		// 학생의 성별과 받은 수
		for(int i = 0; i < student; i++) {
			// sArr[0] : 성별, sArr[1] : 받은 수
			int[] sArr = new int[2];
			for(int s = 0; s < 2; s++) {
				sArr[s] = sc.nextInt();
			}
			
			// 남학생일 때
			if(sArr[0] == 1) {
				for(int j = 0; j < num; j++) {
					// 배수일 때
					if((j + 1) % sArr[1] == 0) {
						// 스위치의 상태를 바꾸는 조건문
						if(oArr[j] == 1) {
							oArr[j] = 0;
						}
						else {
							oArr[j] = 1;
						} // 스위치의 상태를 바꾸는 조건문
					} // 배수일 때
				}
			}
			// 여학생일 때
			else {
				int k = 1;
				int idx = 0;
			
				while(true) {
					if((sArr[1] - 1 - k) < 0) {
						idx = (sArr[1] - k);
						break;
					}
					
					if((sArr[1] - 1 + k) > (num - 1)) {
						idx = (sArr[1] - k);
						break;
					}
					
					if(oArr[sArr[1] - 1 - k] == oArr[sArr[1] - 1 + k]) {
						idx = (sArr[1] - 1 - k);
						k++;
					}
					else {
						idx = (sArr[1] - k);
						break;
					}
					
					} // while
					
					// 구간을 모두 바꿈
					for(int range = idx; range <= idx + ((sArr[1] - 1 - idx) * 2); range++) {
						// 스위치의 상태를 바꾸는 조건문
						if(oArr[range] == 1) {
							oArr[range] = 0;
						}
						else {
							oArr[range] = 1;
						} // 스위치의 상태를 바꾸는 조건문
					}	
				} // 여자 else문
		}
		
		for(int i = 0; i < oArr.length; i++) {
			System.out.print(oArr[i] + " ");
			
			if((i + 1) % 20 == 0) {
				System.out.println();
			}
		}
	}
}