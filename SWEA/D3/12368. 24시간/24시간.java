import java.util.Scanner;

class Solution {
	public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        
        for(int t = 1; t <= T; t++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            
            System.out.println("#" + t + " " + (A + B) % 24);
        }
    }
}
		