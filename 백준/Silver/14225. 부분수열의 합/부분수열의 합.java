import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static int N;
    static int[] num;
    static boolean[] visited;
    static ArrayList<Integer> sumArr;

    public static void powerset(int idx) {
        if(idx == N) {
            int sum = 0;

            for(int i = 0; i < N; i++) {
                if(visited[i]) {
                    sum += num[i];
                }
            }

            sumArr.add(sum);

            return;
        }

        // 재귀
        visited[idx] = true;
        powerset(idx+1);
        visited[idx] = false;
        powerset(idx+1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        num = new int[N];
        for(int i = 0; i < N; i++) {
            num[i] = sc.nextInt();
        }

        visited = new boolean[N];
        sumArr = new ArrayList<>();

        powerset(0);

        // 오름차순 정렬
        Collections.sort(sumArr);

        // 출력
        int ans = 0;
        for(int i = 1; i < sumArr.size(); i++) {
            if(sumArr.get(i) - sumArr.get(i-1) > 1) {
                ans = sumArr.get(i-1) + 1;
                break;
            }
            ans = sumArr.get(i) + 1;
        }

        System.out.println(ans);
    }
}
