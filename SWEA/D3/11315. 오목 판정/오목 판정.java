import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			System.out.print("#" + tc + " ");
			
			int N = sc.nextInt();
			int[][] board = new int[N+2][N+2];
			for (int i = 1; i < (N + 1); i++) {
				String str = sc.next();
	            for (int j = 1; j < (N + 1); j++)
	                board[i][j] = str.charAt((j - 1));
	        }
			
			 // 모든 칸을 검사하기 시작
			Loop : 
			for (int i = 1; i < (N + 1); i++) {
	            for (int j = 1; j < (N + 1); j++) {
	            	// 돌을 만나면
	                if(board[i][j] == 'o') {
	                	int row = i;
	                	int col = j;
	                	// 우방향으로 오목세기
	                	int cnt = 1;
	                	while(true) {
	                		col++;
	                		 if(board[row][col] == 'o') {
	     	                	cnt++;
	                		 }
	                		 else {
	                			 break;
	                		 }
	                		 
	                		 if(cnt == 5) {
	                			 System.out.println("YES");
	                			 break Loop;
	                		 }
	                	}
	                	
	                	// 아래방향으로 오목세기
	                	cnt = 1;
	                	row = i; col = j;
	                	while(true) {
	                		row++;
	                		 if(board[row][col] == 'o') {
	     	                	cnt++;
	                		 }
	                		 else {
	                			 break;
	                		 }
	                		 
	                		 if(cnt == 5) {
	                			 System.out.println("YES");
	                			 break Loop;
	                		 }
	                	}
	                	
	                	// 좌측 아래방향으로 오목세기
	                	cnt = 1;
	                	row = i; col = j;
	                	while(true) {
	                		row++; col--;
	                		 if(board[row][col] == 'o') {
	     	                	cnt++;
	                		 }
	                		 else {
	                			 break;
	                		 }
	                		 
	                		 if(cnt == 5) {
	                			 System.out.println("YES");
	                			 break Loop;
	                		 }
	                	}
	                	
	                	//우측 아래방향으로 오목세기
	                	cnt = 1;
	                	row = i; col = j;
	                	while(true) {
	                		row++; col++;
	                		 if(board[row][col] == 'o') {
	     	                	cnt++;
	                		 }
	                		 else {
	                			 break;
	                		 }
	                		 
	                		 if(cnt == 5) {
	                			 System.out.println("YES");
	                			 break Loop;
	                		 }
	                	}
	                }
	                
	                if(i == N && j == N) {
	                	System.out.println("NO");
	                }
	            }
			}
		}	// 테케 끝
	}
}