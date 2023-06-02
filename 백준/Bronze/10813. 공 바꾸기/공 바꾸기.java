import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();
        // 초기 바구니 세팅
        int[] bk = new int[N+1];
        for(int i = 1; i < bk.length; i++) {
            bk[i] = i;
        }

        int M = sc.nextInt();
        for(int i = 0; i < M; i++) {
            int idx = sc.nextInt();
            int jdx = sc.nextInt();

            int tmp = bk[idx];
            bk[idx] = bk[jdx];
            bk[jdx] = tmp;
        }

        for(int i = 1; i < bk.length; i++) {
            sb.append(bk[i]).append(" ");
        }

        System.out.println(sb);
    }
}
