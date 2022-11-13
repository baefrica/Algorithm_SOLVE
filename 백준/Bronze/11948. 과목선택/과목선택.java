import java.util.Scanner;

public class Main {
	static int[] sb1 = new int[4];
	
	// swap
	public static void swap(int a, int b) {
		int tmp = sb1[a];
		sb1[a] = sb1[b];
		sb1[b] = tmp;
	}
	
	// main
	public static void main(String[] args) {
		// 물리, 화학, 생물, 지구과학, 역사, 지리 총 6과목
		// 각 시험 만점은 100점
		// 물화생지 중 3과목, 역지 중 1과목 선택
		// 시험 점수의 합이 가장 높게
		Scanner sc = new Scanner(System.in);
		
		// 물화생지 점수 입력받는다
		for(int i = 0; i < sb1.length; i++) {
			sb1[i] = sc.nextInt();
		}
		// 물화생지 점수 "선택 정렬" 로 내림차순
		for(int i = 0; i < (sb1.length - 1); i++) {
			int maxIdx = i;
			for(int j = (i + 1); j < sb1.length; j++) {
				if(sb1[j] > sb1[maxIdx]) {
					maxIdx = j;
				}
			}
			
			swap(maxIdx, i);
		}
		
		// 역사, 지리 중 높은 점수 선택
		int sb2 = 0;
		for(int i = 0; i < 2; i++) {
			sb2 = Math.max(sc.nextInt(), sb2);
		}
		
		// 출력
		int sum = 0;
		for(int i = 0; i < 3; i++) {
			sum += sb1[i];
		}
		System.out.println(sum + sb2);
	}
}