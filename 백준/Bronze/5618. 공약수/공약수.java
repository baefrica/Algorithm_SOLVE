import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            max = Math.max(arr[i], max);
        }

        for(int i = 1; i <= max; i++) {
            boolean flag = true;
            for(int j = 0; j < arr.length; j++) {
                if(arr[j] % i != 0) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                System.out.println(i);
            }
        }
    }
}
