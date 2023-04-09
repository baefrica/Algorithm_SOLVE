import java.util.Scanner;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int M;
    static int[] result;

    // 순열을 구하는 함수 perm()
    static void perm(int idx) {
        // 기저조건
        if(idx == M) {
            for (int i : result) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 1; i <= N; i++) {
            result[idx] = i;
            perm(idx+1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1부터 N 까지의 수 중에서 중복 없이 M개를 고른 수열
        // 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력
        N = sc.nextInt();
        M = sc.nextInt();   // 길이가 M인 수열 만들기

        result = new int[M];

        perm(0);
        
        // "시간초과"가 떠서..
        System.out.print(sb);
    }
}
