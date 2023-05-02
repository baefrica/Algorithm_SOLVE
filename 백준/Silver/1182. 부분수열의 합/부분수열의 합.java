import java.util.Scanner;

public class Main {
    static int N, S;
    static int[] num;
    static boolean[] visited;
    static int cnt;

    public static void powerset(int idx) {
        // idx 가 N 까지 도달하면
        if(idx == N) {
            int sum = 0;
            
            // 반복문을 돌며 true 인 값들의 합을 구한다
            for(int i = 0; i < N; i++) {
                if( visited[i] ) {
                    sum += num[i];
                }
            }

            // 합이 S가 되는 부분수열의 개수 하나 증가
            if(sum == S) {
                cnt++;
            }

            return;
        }
        
        // 부분수열 구하는 재귀 공식
        visited[idx] = true;
        powerset(idx+1);
        visited[idx] = false;
        powerset(idx+1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        S = sc.nextInt();

        num = new int[N];
        visited = new boolean[N];
        for(int i = 0; i < N; i++) {
            num[i] = sc.nextInt();
        }

        powerset(0);
        
        // 크기가 양수인 부분수열 이므로 공집합 제외
        // 공집합의 합은 0이므로
        // S 가 0일 때는 하나 빼준다.
        if(S == 0) {
            cnt--;
        }
        System.out.println(cnt);
    }
}
