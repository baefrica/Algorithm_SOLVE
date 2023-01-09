import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	// GCD : 최대공약수
	public static long GCD(long a, long b) {
		// b 가 더 크면, a랑 b 교환
		if(b < a) {
			long tmp = a;
			a = b;
			b = tmp;
		}
		
		while(a % b != 0) {
			long tmp = a % b;
			a = b;
			b = tmp;
		}
		
		return b;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		long gcd = GCD( Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()) );
		for(long i = 0; i < gcd; i++) {
			sb.append(1);
		}
		
		System.out.println(sb);
	}
}