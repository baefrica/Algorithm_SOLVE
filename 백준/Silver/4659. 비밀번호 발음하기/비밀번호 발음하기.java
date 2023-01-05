import java.util.Scanner;

public class Main {
    static String pw;

    // vowelCheck
    public static boolean vowelCheck() {
        for(int i = 0; i < pw.length(); i++) {
            // 모음이 포함됨
            if( pw.charAt(i) == 'a' || pw.charAt(i) == 'e' || pw.charAt(i) == 'i' || pw.charAt(i) == 'o' || pw.charAt(i) == 'u' ) {
                return true;
            }
        }
        return false;
    }

    // tripleCheck
    public static boolean tripleCheck() {
        int cnt = 1;
        int flag = -1;  // 모음이면 0, 자음이면 1

        for(int i = 0; i < pw.length(); i++) {
            // 모음을 만나면
            if( pw.charAt(i) == 'a' || pw.charAt(i) == 'e' || pw.charAt(i) == 'i' || pw.charAt(i) == 'o' || pw.charAt(i) == 'u' ) {
                if(flag == 0) {
                    cnt++;
                }
                else {
                    cnt = 1;
                }
                // flag=0로 바꿔줌
                flag = 0;
            }
            // 자음을 만나면
            else {
                if(flag == 1) {
                    cnt++;
                }
                else {
                    cnt = 1;
                }
                // flag=1로 바꿔줌
                flag = 1;
            }

            if(cnt == 3) {
                return true;
            }
        }

        return false;
    }

    // doubleCheck
    public static boolean doubleCheck() {
        int cnt = 1;

        for(int i = 0; i < (pw.length() - 1); i++) {
            // ee 나 oo 는 괜찮다
            if(pw.charAt(i) == 'e' || pw.charAt(i) == 'o') {
                continue;
            }

            if(pw.charAt(i) == pw.charAt(i + 1)) {
                cnt++;
            }
            else {
                cnt = 1;
            }

            if(cnt == 2) {
                return true;
            }
        }

        return false;
    }

    // main
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true) {
            pw = sc.next();

            if(pw.equals("end")) {
                break;
            }

            boolean isHaveVowel = vowelCheck();
            boolean isTriple = tripleCheck();
            boolean isDouble = doubleCheck();

            if( !isHaveVowel || isTriple || isDouble ) {
                System.out.println("<" + pw + "> " + "is not acceptable.");
            }
            else {
                System.out.println("<" + pw + "> " + "is acceptable.");
            }
        }
    }
}