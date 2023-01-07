import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        String ans = "";
        
        // 문자열 각각 알파벳을 순환할건데..
        for ( char c : word.toCharArray() ) {
        	// 소문자이면
            if ( Character.isLowerCase(c) ) {
            	// 대문자로 바꿔주고
                ans += Character.toUpperCase(c);
            }
            // 아니면
            else {
            	// 소문자로 바꿔줘라
            	ans += Character.toLowerCase(c);
            }
        }

        System.out.println(ans);
    }
}