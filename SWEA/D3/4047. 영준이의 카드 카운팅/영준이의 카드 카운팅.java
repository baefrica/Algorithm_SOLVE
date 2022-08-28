import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#" + tc + " ");
			
			String card = br.readLine();
			
			int sCnt = 0;
			int dCnt = 0;
			int hCnt = 0;
			int cCnt = 0;
			
			// 카드 종류 판별해서 갯수 세기
			for(int i = 0; i < card.length(); i += 3) {
				switch(card.charAt(i)) {
				case 'S' :
					sCnt++;
					break;
					
				case 'D' :
					dCnt++;
					break;
					
				case 'H' :
					hCnt++;
					break;
					
				case 'C' :
					cCnt++;
					break;
				}	// 스위치-케이스 문
			}	// 카드 종류 판별
			
			// 에러 판별
			// 3개씩 쪼갠 거 넣을 배열 생성
			String[] arr = new String[card.length() / 3];
			int idx = 0;
			// 3개씩 쪼개서 넣는다
			for(int i = 3; i <= card.length(); i += 3) {
				arr[idx++] = card.substring((i - 3), i);
			}
			
			// 똑같은 카드가 있으면 flag = false
			boolean flag = true;
			Loop :
			for(int i = 0; i < (arr.length - 1); i++) {
				for(int j = (i + 1); j < arr.length; j++) {
					if(arr[i].equals(arr[j])) {
						flag = false;
						break Loop;
					}
				}
			}
			
			if(flag == false) {
				sb.append("ERROR");
			}
			else {
				sb.append((13 - sCnt) + " " + (13 - dCnt) + " " + (13 - hCnt) + " " + (13 - cCnt));
			}
			
			System.out.println(sb);			
		}
	}
}