import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		char[][] num = new char[N][3];
		int[][] arr = new int[N][2];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			num[i] = st.nextToken().toCharArray();
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int cnt = 0;
		for(int i = 123; i < 988; i++) {
			char[] tmp = Integer.toString(i).toCharArray();
			
			// 기저조건
			if(tmp[0] == tmp[1] || tmp[1] == tmp[2] || tmp[2] == tmp[0]) {
				continue;
			}
			if(tmp[1] == '0' || tmp[2] == '0') {
				continue;
			}
			
			boolean isAnswer = true;
			for(int n = 0; n < N; n++) {
				int strike = 0;
				int ball = 0;
				
				// 필수로 거쳐야하는 과정
				for(int s = 0; s < 3; s++) {
					for(int b = 0; b < 3; b++) {
						// 숫자가 같은데
						if(tmp[s] == num[n][b]) {
							// 자릿수가 같다면 스트라이크
							if(s == b) {
								strike++;
							}
							// 다르다면 볼
							else {
								ball++;
							}
						}
					}
				}
				
				// 스트라이크와 볼 수 중 하나라도 일치하지 않으면 정답이 될 수 없다
				if(strike != arr[n][0] || ball != arr[n][1]) {
					isAnswer = false;
					break;
				}
			}
			
			// 정답이 될 수 있는가? -> 그럼 세
			if(isAnswer) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
}