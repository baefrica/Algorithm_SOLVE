import java.util.Scanner;

public class Main {
    static int N;
    static int M;
    static int[] result;
    static boolean[] visited;

    // 순열을 구하는 함수 perm()
    static void perm(int idx) {
        StringBuilder sb = new StringBuilder();

        // 기저조건
        if(idx == M) {
            for (int i : result) {
                sb.append(i).append(" ");
            }
            System.out.println(sb);
            return;
        }

        for(int i = 1; i <= N; i++) {
            // 방문했다면?
            if(visited[i]) {
                continue;
            }

            // idx 가 1부터
            // 앞자리보다 작으면
            if(idx > 0) {
                if(i < result[idx-1]) {
                    continue;
                }
            }

            result[idx] = i;
            visited[i] = true;
            perm(idx+1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1부터 N 까지의 수 중에서 중복 없이 M개를 고른 수열
        // 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력
        N = sc.nextInt();
        M = sc.nextInt();   // 길이가 M인 수열 만들기

        result = new int[M];
        visited = new boolean[N+1];

        perm(0);
    }
}
