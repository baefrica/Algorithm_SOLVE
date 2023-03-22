import java.util.*;

class Solution {
    static class Node {
        int r;
        int c;
        int cnt;
        
        Node(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
    
    public int solution(int[][] maps) {
        Queue<Node> queue = new LinkedList<>();
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        
        int answer = Integer.MAX_VALUE;
        
        queue.add(new Node(0, 0, 1));
        visited[0][0] = true;
        
        int[] dr = { 0, 0, -1, 1 };
        int[] dc = { -1, 1, 0, 0 };
        
        while(!queue.isEmpty()) {
            Node cur = queue.poll();
            
            
            for(int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];
                
                // 경계 체크
                if(nr < 0 || nc < 0 || nr >= maps.length || nc >= maps[0].length) {
                    continue;
                }
                
                // 갈 수 있으면
                if(!visited[nr][nc] && maps[nr][nc] == 1) {
                    queue.add(new Node(nr, nc, cur.cnt + 1));
                    // 방문처리
                    visited[nr][nc] = true;
                }
                
                // 목표 도착했을 때
                if(nr == maps.length - 1 && nc == maps[0].length - 1) {
                    int tmp = cur.cnt + 1;
                    
                    if(answer > tmp) {
                        answer = tmp;
                    }
                }
            }
        }   // while 문 끝
        
        if(answer == Integer.MAX_VALUE) {
            answer = -1;
        }
        
        return answer;
    }
}