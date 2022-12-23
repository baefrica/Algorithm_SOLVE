import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		/* 
		 * Java 를 사용하고 있다면,
		 * Scanner 와 System.out.println 대신 BufferedReader 와 BufferedWriter 를 사용할 수 있다.
		 * BufferedWriter.flush 는 맨 마지막에 한 번만 하면 된다.
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int i = 0 ; i < T ; i++ ) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			bw.write(a + b + "\n");
		}
		
		br.close();
		
		bw.flush();
		bw.close();
	}
}