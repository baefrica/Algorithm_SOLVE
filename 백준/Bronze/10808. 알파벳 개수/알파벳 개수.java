import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        String S = sc.next();
        int[] arr = new int[26];

        for(int i = 0; i < S.length(); i++) {
//            System.out.println(S.charAt(i) - 'a');
            arr[S.charAt(i) - 'a']++;
        }

        for(int i : arr) {
            sb.append(i).append(" ");
        }

        System.out.println(sb);
    }
}
