import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int[] score = new int[8];
		for(int i = 0; i < 8; i++) {
			score[i] = Integer.parseInt(br.readLine());
		}
		
		br.close();
		
		int total = 0;
		for(int i = 0; i < 8; i++) {
			int cnt = 0;
			for(int j = 0; j < 8; j++) {
				if(score[i] > score[j]) {
					cnt++;
					
					if(cnt == 3) {
						total += score[i];
						sb.append((i + 1) + " ");
						break;
					}
				}
			}
		}
		
		System.out.println(total);
		System.out.print(sb);
	}
}