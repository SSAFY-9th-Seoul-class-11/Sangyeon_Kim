package week1;

import java.util.Scanner;

public class View_1206 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		
		for(int tc = 1 ; tc <= T ; tc++) {
			
			int N = sc.nextInt();
			int[] height = new int[N];
			int view = 0;
			
			for(int i = 0 ; i < N ; i++ ) {
				height[i] = sc.nextInt();
			}
			
			for(int i = 2 ; i < N-2 ; i++) {
				int max = Math.max(height[i-2], Math.max(height[i-1], Math.max(height[i+1], height[i+2])));
				if(height[i] - max > 0) 
					view += height[i] - max;
				}
			
				System.out.printf("#%d %d\n", tc, view);
			}
			
			
			
	}

}
