import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static String[] arr;
	
	// swap
	public static void swap(int a, int b) {
		String tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
	
	// main
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		sc.nextLine();
		
		arr = new String[N+1];		// 마지막 칸은 null 로 채워짐
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextLine();
		}
		arr[N] = "";
		
		// 1. 길이가 짧은 것부터
		for(int i = 0; i < (N - 1); i++) {
			for(int j = (i + 1); j < N; j++) {
				if(arr[i].length() > arr[j].length()) {
					swap( i, j );
				}
			}
		}
		
		// 확인용
//		for(int i = 0; i < N; i++) {
//			System.out.println(arr[i]);
//		}
		
		// 2. 길이가 같으면 사전 순으로
		for(int i = 0; i < N; i++) {
			int length = arr[i].length();	// 해당 글자 길이
			int rangeIdx = i;					// 글자 길이 같은 게 어디까지인가
			int cntSame = 1;					// 글자 길이 같은 게 몇개인가
			
			while(true) {
				rangeIdx++;
				if(arr[rangeIdx].length() != length) {
					rangeIdx--;
					break;
				}
				else {
					cntSame++;
				}
			}
			
			// 글자 길이가 같은 게 없다면
			if(cntSame == 1) {
				continue;
			}
			// 글자 길이가 같은 게 여러 개일때만
			// 부분 사전순 정렬
			else {
				Arrays.sort( arr, i, (rangeIdx + 1) );
				
				// i 를 껑충
				i = rangeIdx;
			}
		}
		
		// 출력
		for(int i = 0; i < N; i++) {
			if(arr[i].equals(arr[i+1])) {
				continue;
			}
			else {
				System.out.println(arr[i]);
			}
		}	// 출력 끝
	}
}

//13
//but
//i
//wont
//hesitate
//no
//more
//no
//more
//it
//cannot
//wait
//im
//yours
