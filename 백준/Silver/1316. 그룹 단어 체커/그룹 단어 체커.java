import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int ans = 0;
		for(int i = 0; i < N; i++) {
			// char 배열로 쪼개 담는다
			char[] alpha = br.readLine().toCharArray();
			// 그룹 단어인지 판별용
			boolean isGroup = true;
			
			Loop :
			for(int j = 0; j < alpha.length; j++) {
				// 뒤에 또 중복으로 나오면 break 해야하는 상황인지 부여
				boolean state = true;
				
				for(int k = (j + 1); k < alpha.length; k++) {
					if(alpha[j] == alpha[k]) {
						// state 가 true 일 때
						// 연속으로 중복으로 나와도 됨
						if(state) {
							continue;
						}
						// state 가 false 일 때 :
						// 떨어져서 중복으로 나타남
						else {
							isGroup = false;
							break Loop;
						}
					}
					// 연속 깨짐
					else {
						state = false;
					}
				}
			}
			
			// 그룹 단어 맞니?
			if(isGroup) {
				ans++;
			}
		}
		
		System.out.println(ans);
	}
}