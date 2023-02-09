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
			int n = 0; // 작동 횟수
			
			while(true) {
				if(gap <= n * (n+1)) break;
				n += 1;
			}
			
			if(gap <= Math.pow(n, 2))
				System.out.println(n * 2 - 1);
			else 
				System.out.println(n * 2);
			
		}

	}

}
