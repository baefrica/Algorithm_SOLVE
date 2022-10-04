public class Main {
	// n과 n의 각 자리수를 더하는 함수
	public static int d(int n) {
		int sum = n;
		
		String N = Integer.toString(n);
		
		for(int i = 0; i < N.length(); i++) {
			sum += (N.charAt(i) - 48);
		}
		
		return sum;
	}
	
	// main
	public static void main(String[] args) {
		boolean[] arr = new boolean[10001];
		// 셀프 넘버가 아닌 수들을 true 표시
		for(int i = 1; i < arr.length; i++) {
			if(d(i) <= 10000) {
				arr[d(i)] = true;
			}
		}
		
		// false 인 셀프 넘버들만 출력
		for(int i = 1; i < arr.length; i++) {
			if(!arr[i]) {
				System.out.println(i);
			}
		}
	}
}