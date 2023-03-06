import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 다른 사람 코드 !!
        // 사실 더 쉽게 할 수 있다.. 왜냐하면 그리디
        // 그리구 실버 5니까..
        // OK. 그리디는 좀 더 효율적으로 풀 생각을 하자.
        // OK. 실버 정도는 좀 더 쉽게 생각을 하자.
        String poly = sc.next();

        // 1. 4콤보 X 를 AAAA 로 바꿈
        poly = poly.replaceAll("XXXX", "AAAA");
        // 2. 2콤보 X 를 BB 로 바꿈
        poly = poly.replaceAll("XX", "BB");

        if(poly.contains("X")) {
            System.out.println(-1);
        }
        else {
            System.out.println(poly);
        }


        // 이건 내가 푼 코드 !!
//        StringBuilder sb = new StringBuilder();
//
//        String poly = sc.next();
//        boolean flag = true;
//        int cnt = 0;
//        for(int i = 0; i < poly.length(); i++) {
//            // X 일때
//            if(poly.charAt(i) == 'X') {
//                cnt++;
//
//                if(cnt > 4) {
//                    sb.append("AAAA");
//                    cnt = 1;
//                }
//
//                // 마지막 인덱스에 왔을 때
//                if(i == poly.length()-1) {
//                    if(cnt == 4) {
//                        sb.append("AAAA");
//                    }
//                    else if(cnt == 2) {
//                        sb.append("BB");
//                    }
//                    else {
//                        flag = false;
//                        break;
//                    }
//                }
//            }
//            // . 일때
//            else {
//                if(cnt == 4) {
//                    sb.append("AAAA");
//                }
//                else if(cnt == 2) {
//                    sb.append("BB");
//                }
//                else if(cnt == 0) {
//                    // 아래 코드 추가해줘야함 -> "...." 반례를 통해 알게됨
//                    sb.append(".");
//                    continue;
//                }
//                else {
//                    flag = false;
//                    break;
//                }
//
//                sb.append(".");
//                cnt = 0;
//            }
//        }   // for 문 끝
//
//        if(!flag) {
//            System.out.println(-1);
//        }
//        else {
//            System.out.println(sb);
//        }
    }
}
