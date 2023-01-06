import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	// GCD (최대공약수)
	public static int GCD(int a, int b) {
		if( b == Math.max(a, b) ) {
			int tmp = a;
			a = b;
			b = tmp;
		}
		
		while( a % b != 0) {
			int tmp = (a % b);
			a = b;
			b = tmp;
		}
		
		return b;
	}
	
	// LCM (최소공배수)
	public static int LCM(int a, int b) {
		return (a * b) / GCD(a, b);
	}
	
	// main
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            // 1 ≤ M, N ≤ 40,000, 1 ≤ x ≤ M, 1 ≤ y ≤ N
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int k = -1;
            int mod = 0;
            // 시간 초과가 계속 나서...
            // 마지막 해까지만 검사
            // 마지막 해가 최소공배수날이다
            for(int ty = x; ty <= LCM(M, N); ty += M) {
            	// 처음부터 x=y 인 날
        	   if(ty == y) {
        		   k = ty;
        		   break;
        	   }
        	   else {
        		   // ty 를 M 만큼 증가시켜주고
        		   // N 으로 나눈 나머지가 y 값의 비교대상이 된다
        		   // 단, 나머지가 0일 땐 N 을 그대로 가져온다
        		   if(ty % N == 0) {
        			   mod = N;
        		   }
        		   else {
        			   mod = ty % N;
        		   }
        	   }
        	   
        	   // 일치하는 해를 찾으면 k 출력
        	   if(mod == y) {
        		   k = ty;
        		   break;
        	   }
           }
           
            // k 가 바뀌지 않으면 -1 이 출력됨
           System.out.println(k);
        }
    }
}
