package week5;

import java.util.Scanner;

public class BOJ_1011 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1 ; tc <= T ; tc++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int gap = y - x;
			
			int max = (int)Math.sqrt(gap);
			
			if (max == Math.sqrt(gap)) {
				System.out.println(max * 2 - 1);
			}else if(gap <= max * max + max) {
				System.out.println(2 * max);
			}else {
				System.out.println(max * 2 +1);
			}
			
			
		}

	}

}
