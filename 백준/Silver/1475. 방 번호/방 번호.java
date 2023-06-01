import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] numCnt = new int[9];

        while(N > 0) {
            int number = N % 10;

            // 9랑 6은 같다.
            if(number == 9) {
                number = 6;
            }

            numCnt[number]++;
            N /= 10;
        }

        // 6의 갯수는 절반으로
        if(numCnt[6] % 2 == 0) {
            numCnt[6] /= 2;
        }
        else {
            numCnt[6] /= 2;
            numCnt[6]++;
        }

        int maxNum = 0;
        for(int i : numCnt) {
            maxNum = Math.max(i, maxNum);
        }

        System.out.println(maxNum);
    }
}
