import java.util.Scanner;

public class Main {
    static int N;
    static int[] num;
    // 가지고 있는 연산자 종류 배열
    static int[] tool = new int[4];
    static long maxAns = Integer.MIN_VALUE;
    static long minAns = Integer.MAX_VALUE;

    // 백트래킹
    static void backtracking(int curNum, int numIdx) {
        // 기저조건
        if(numIdx == N) {
            maxAns = Math.max(maxAns, curNum);
            minAns = Math.min(minAns, curNum);
            return;
        }

        for(int i = 0; i < 4; i++) {
            // 연산자가 1개 이상 존재하는 경우
            if(tool[i] > 0) {
                tool[i]--;

                switch(i) {
                    // 덧셈
                    case 0 :
                        backtracking(curNum + num[numIdx], numIdx+1);
                        break;
                    // 뺄셈
                    case 1 :
                        backtracking(curNum - num[numIdx], numIdx+1);
                        break;
                    // 곱셈
                    case 2 :
                        backtracking(curNum * num[numIdx], numIdx+1);
                        break;
                    // 나눗셈
                    case 3 :
                        backtracking(curNum / num[numIdx], numIdx+1);
                        break;
                }   // switch 끝

                tool[i]++;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        // 숫자배열
        num = new int[N];

        for(int i = 0; i < N; i++) {
            num[i] = sc.nextInt();
        }

        for(int i = 0; i < 4; i++) {
            tool[i] = sc.nextInt();
        }

        // 연산의 결과와 숫자배열 인덱스를 증가시키면서 백트래킹하기 !!
        backtracking(num[0], 1);

        System.out.println(maxAns);
        System.out.println(minAns);
    }
}
