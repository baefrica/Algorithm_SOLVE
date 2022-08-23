import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // BigInteger 는 범위가 무한대인 정수
        BigInteger a = sc.nextBigInteger();
        BigInteger b = sc.nextBigInteger();
        
        // BigInteger 쓸 때 나누기
        System.out.println(a.divide(b));
        // BigInteger 쓸 때 나머지 구하기
        System.out.println(a.remainder(b));
    }
}