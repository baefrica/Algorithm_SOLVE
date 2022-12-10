import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i < 3; i++) {
			int cntZero = 0;
			
			for(int j = 0; j < 4; j++) {
				// 배 : 0, 등 : 1
				// 도(배 1개, 등 3개)
				// 개(배 2개, 등 2개)
				// 걸(배 3개, 등 1개)
				// 윷(배 4개)
				// 모(등 4개)
				int state = sc.nextInt();
				if(state == 0) {
					cntZero++;
				}
			}
			
			switch(cntZero) {
			case 1 :
				System.out.println("A");
				break;
				
			case 2 :
				System.out.println("B");
				break;
				
			case 3 :
				System.out.println("C");
				break;
				
			case 4 :
				System.out.println("D");
				break;
				
			case 0 :
				System.out.println("E");
				break;
			}
		}	// 이중 for문 끝
	}
}

//# input :
//0 1 0 1
//1 1 1 0
//0 0 1 1
