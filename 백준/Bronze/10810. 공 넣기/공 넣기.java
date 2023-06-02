import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();
        int[] basket = new int[N+1];
        int M = sc.nextInt();
        for(int i = 0; i < M; i++) {
            int st = sc.nextInt();
            int ed = sc.nextInt();
            int k = sc.nextInt();
            // 공 넣기
            for(int j = st; j <= ed; j++) {
                basket[j] = k;
            }
        }

        for(int i = 1; i < basket.length; i++) {
            sb.append(basket[i]).append(" ");
        }

        System.out.println(sb);
    }
}
