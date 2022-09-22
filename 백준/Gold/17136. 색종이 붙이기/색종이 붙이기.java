import java.util.Scanner;

public class Main {
    static int[][] board;	// 네모칸
    static int[] paper = {5, 5, 5, 5, 5};		// 사이즈 별로 색종이 갯수
    static int ans = Integer.MAX_VALUE;
    
    public static void colorPaper(int r, int c, int cnt) {
    	// 기저 조건
    	// 좌표가 (10, 10) 까지 갔을 때, 색종이 갯수의 최솟값
    	if(r >= 9 && c > 9) {
    		ans = Math.min(ans, cnt);
    		return;
    	}
    	// 오른쪽으로 이동하다가 끝났으면 아래칸으로 가자
    	if(c == 10) {
            colorPaper(r + 1, 0, cnt);
            return;
        }
    	// 세다가 이미 최소를 넘으면 바로 종료시켜
    	if(cnt >= ans) {
    		return;
    	}
    	// 1을 찾았다면
        if(board[r][c] == 1) {
        	// 5X5 색종이 부터 붙여봐야지
        	int max = 5;
        	for(int i = 1; i <= max; i++) {
        		// 색종이를 붙일 수 있다면
        		if(isPossible(r, c, i) && paper[i-1] > 0) {
        			// 1의 위치로부터 그 크기의 색종이를 붙인다
        			addPaper(r, c, i);
        			// 해당 크기의 종이 하나 없애주고
        			paper[i-1]--;
        			colorPaper(r, c+1, cnt+1);
        			// 붙인 색종이를 떼준다
        			removePaper(r, c, i);
        			// 다시 복구
        			paper[i-1]++;
        		}
            }
        }
        // 못 찾으면 계속 다음 칸 ㄱㄱ
        else {
        	colorPaper(r, c+1, cnt);
        }
    }
        
    // isPossible : 색종이 붙일 수 있는지 확인
    public static boolean isPossible(int r, int c, int size) {
	    	for(int i = r; i < r + size; i++) {
	    		for(int j = c; j < c + size; j++) {
	    			// 범위 밖으로 나가면
	                  if(i >= 10 || j >= 10) {
	                      return false;
	                  }
	                  
	                  if(board[i][j] != 1) {
	                	  return false;
	                  }
	    		}
	    	}
	    	// 아니면 붙일 수 있어
	    	return true;
    }
    
    // addPaper : 색종이 붙이기
    public static void addPaper(int r, int c, int size) {
    	for(int i = r; i < r + size; i++) {
    		for(int j = c; j < c + size; j++) {
    			board[i][j] = 2;
    		}
    	}
    }
    
    // removePaper : 색종이 떼기
    public static void removePaper(int r, int c, int size) {
    	for(int i = r; i < r + size; i++) {
    		for(int j = c; j < c + size; j++) {
    			board[i][j] = 1;
    		}
    	}
    }
    
    // main
    public static void main(String[] args) {
    	
        Scanner sc = new Scanner(System.in);
        
        board = new int[10][10];
        
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        
        colorPaper(0, 0, 0);
        
        if(ans == Integer.MAX_VALUE) {
        	System.out.println(-1);
        }
        else {
        	System.out.println(ans);
        }
    }
}