import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String S = sc.next();
        String K = sc.next();

        String tmp = "";

        for(int i = 0; i < S.length(); i++) {
            if(S.charAt(i) - '0' > 9) {
                tmp += S.charAt(i);
            }
        }

        if(tmp.contains(K)) {
            System.out.println(1);
        }
        else {
            System.out.println(0);
        }
    }
}
