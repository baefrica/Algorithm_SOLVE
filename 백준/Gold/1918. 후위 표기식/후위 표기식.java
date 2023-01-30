import java.util.Scanner;
import java.util.Stack;

public class Main {
    // 중위표기식을 계산을 하려면...
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        String str = sc.next();

        // 1. 후위 표기식으로 변경한다. (스택 : 연산자) : Stack<Character>
        Stack<Character> stack = new Stack<>();
        // 1-1. 토큰을 읽는다. (요소를 하나씩 읽는다.)
        for(int i = 0; i < str.length(); i++) {
            int tmp = str.charAt(i);
            // 1-2. 피연산자라면 출력한다.
            if(tmp >= 65 && tmp <= 90) {
                sb.append(str.charAt(i));
            }
            // 1-3. 연산자라면..
            else {
                // 1-3-1. 스택이 공백상태라면 그냥 넣는다.
                if(stack.isEmpty()) {
                    stack.push(str.charAt(i));
                }
                // 1-3-2. 스택이 공백상태가 아니라면 top 에 있는 연산자와 읽은 연산자를 비교하여 읽은 연산자가 찍어 누를 수 있을 때까지 pop 하고 찍어 누를 수 있으면 넣는다.
                // 1-3-3. 연산자의 우선순위는..(수치가 클수록 순위가 높음)
                // ① '(' -> 안 : 0, 밖 : 3
                // ② '*', '/' -> 안, 밖 : 2
                // ③ '+', '-' -> 안, 밖 : 1
                // ')' -> 어짜피 넣지 않을 친구라 고려 x
                else {
                    char top = stack.peek();

                    switch(str.charAt(i)) {
                        case '(' :
                            stack.push(str.charAt(i));
                            break;

                        case '*' : case '/' :
                            if(top == '(' || top == '+' || top == '-') {
                                stack.push(str.charAt(i));
                            }
                            else {
                                while(true) {
                                    if(stack.isEmpty()) {
                                        stack.push(str.charAt(i));
                                        break;
                                    }

                                    top = stack.peek();

                                    if(top == '(' || top == '+' || top == '-') {
                                        stack.push(str.charAt(i));
                                        break;
                                    }
                                    else {
                                        sb.append(stack.pop());
                                    }
                                }
                            }
                            break;

                        case '+' : case '-' :
                            if(top == '(') {
                                stack.push(str.charAt(i));
                            }
                            else {
                                while(true) {
                                    if(stack.isEmpty()) {
                                        stack.push(str.charAt(i));
                                        break;
                                    }

                                    top = stack.peek();

                                    if(top == '(' || stack.isEmpty()) {
                                        stack.push(str.charAt(i));
                                        break;
                                    }
                                    else {
                                        sb.append(stack.pop());
                                    }
                                }
                            }
                            break;

                        // 1-4. 닫는 소괄호 라면 여는 소괄호를 만날때까지 pop 하여 출력하고, '('는 출력하지 않고 pop 한다.
                        case ')' :
                            while(true) {
                                top = stack.peek();

                                if(top == '(') {
                                    stack.pop();
                                    break;
                                }
                                else{
                                    sb.append(stack.pop());
                                }
                            }
                            break;
                    }   // switch 문 끝
                }
            }
            // 1-5. 토큰을 전부 읽을 때까지 반복한다.
        }   // for 문 끝
        // 1-6. 토큰을 다 읽었는데 스택이 공백이 아니라면 스택이 공백상태가 될때까지 pop 하여 출력한다.
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb);

        //2. 변경한 후위표기식을 계산한다. (스택 : 피연산자) : Stack<Integer>
        //2-1. 토큰을 읽는다. (요소를 하나씩 읽는다.)
        //2-2. 피연산자라면 스택에 넣는다.
        //2-3. 연산자라면 필요한 피연산자만큼 꺼내어 계산하고 다시 결과를 집어 넣는다. (순서가 중요하다.!!!!!)
        //2-4. 토큰을 전부 읽을 때까지 반복한다.
        //2-5. 토큰을 다 읽고 처리했다면, 마지막으로 pop 하여 결과를 출력한다.
    }
}
