import java.util.Scanner;

public class Main {
    static int N;
    static int[][] map;
    static boolean[] visited;
    static int[] start;
    static int minAnswer;

    static int score(boolean[] visited) {
        int startSum = 0;
        int linkSum = 0;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                // 같은 번호면 넘어가
                if(i == j) {
                    continue;
                }

                // start 팀이라면
                if(visited[i] && visited[j]) {
                    startSum += map[i][j];
                }
                // link 팀이라면
                if(!visited[i] && !visited[j]) {
                    linkSum += map[i][j];
                }
            }
        }

        return Math.abs(startSum - linkSum);
    }

    static void perm(int idx) {
        // start 팀과 link 팀으로 나누었다.
        if(idx == N / 2) {
            minAnswer = Math.min(minAnswer, score(visited));
            return;
        }

        for(int i = 0; i < N; i++) {
            if(visited[i]) {
                continue;
            }

            if(idx > 0) {
                if(i < start[idx - 1]) {
                    continue;
                }
            }

            start[idx] = i;
            visited[i] = true;
            perm(idx + 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        visited = new boolean[N];
        start = new int[N / 2];
        map = new int[N][N];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        minAnswer = Integer.MAX_VALUE;
        perm(0);
        System.out.println(minAnswer);
    }
}
