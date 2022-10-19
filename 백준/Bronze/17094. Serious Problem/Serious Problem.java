import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
        int len = sc.nextInt();
		String s = sc.next();
        
		int cnt = 0;	// 2의 갯수 카운팅
		for(int i = 0; i < len; i++) {
			if(s.charAt(i) == '2') {
				cnt++;
			}
		}
		
		if(cnt > ((double) len/2)) {
			System.out.print(2);
		}
		else if(cnt < ((double) len/2)) {
			System.out.print("e");
		}
		else {
			System.out.print("yee");
		}
    }
}