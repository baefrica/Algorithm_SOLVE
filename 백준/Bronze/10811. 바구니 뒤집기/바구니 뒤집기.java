import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();
        int[] bk = new int[N+1];
        for(int i = 1; i < bk.length; i++) {
            bk[i] = i;
        }

        int M = sc.nextInt();
        for(int i = 0; i < M; i++) {
            int idx = sc.nextInt();
            int jdx = sc.nextInt();
            int range = jdx - idx + 1;

            // 역순으로 교환
            for(int j = 0; j < (range / 2); j++) {
                int tmp = bk[idx + j];
                bk[idx + j] = bk[jdx - j];
                bk[jdx - j] = tmp;
            }
        }

        for(int i = 1; i < bk.length; i++) {
            sb.append(bk[i]).append(" ");
        }
        System.out.println(sb);
    }
}
