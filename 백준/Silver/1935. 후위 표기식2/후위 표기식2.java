import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];

        String str = sc.next();

        for(int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        // 1. 변경한 후위표기식을 계산한다. (스택 : 피연산자) : Stack<Integer>
        Stack<Double> stack = new Stack<>();

        // 1-1. 토큰을 읽는다. (요소를 하나씩 읽는다.)
        for(int i = 0; i < str.length(); i++) {
            // 1-2. 피연산자라면 스택에 넣는다.
            int AtoZ = str.charAt(i) - 65;

            if(AtoZ >= 0 && AtoZ <= 25) {
                stack.push((double) arr[AtoZ]);
            }
            // 1-3. 연산자라면 필요한 피연산자만큼 꺼내어 계산하고 다시 결과를 집어 넣는다. (순서가 중요하다.!!!!!)
            else {
                double num2 = stack.pop();
                double num1 = stack.pop();

                switch(str.charAt(i)) {
                case '+' :
                    stack.push(num1 + num2);
                    break;

                case '-' :
                    stack.push(num1 - num2);
                    break;

                case '*' :
                    stack.push(num1 * num2);
                    break;

                case '/' :
                    stack.push(num1 / num2);
                    break;
                }   // switch 문 끝
            }
            // 1-4. 토큰을 전부 읽을 때까지 반복한다.
        }   // for 문 끝

        // 1-5. 토큰을 다 읽고 처리했다면, 마지막으로 pop 하여 결과를 출력한다.
        System.out.printf("%.2f", stack.pop());
    }
}
