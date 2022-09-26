import java.util.Scanner;

public class Test {
	// 합을 구하는 sum 함수
    long sum(int[] a) {
        long ans = 0;
        
        for(int i = 0; i < a.length; i++) {
			ans += a[i];
		}
        
        return ans;
    }
    
    // main
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] a = new int[n];
		for(int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
	}
}