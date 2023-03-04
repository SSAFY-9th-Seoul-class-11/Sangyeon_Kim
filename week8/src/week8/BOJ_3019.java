package week8;

import java.util.Scanner;

public class BOJ_3019 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int C = sc.nextInt();
		int P = sc.nextInt() -1;
		
		int[][][] block = 
				{{{0}, {0,0,0,0}}, 
				{{0, 0}}, 
				{{0,0,1}, {1, 0}}, 
				{{1, 0, 0,}, {0, 1}}, 
				{{0,0,0}, {1, 0}, {1, 0, 1}, {0, 1}}, 
				{{0,0,0},{0,0},{0,1,1},{2,0}}, 
				{{0,0,0},{0,0},{1,1,0},{0,2}}};
		
		int[] height = new int[C];
		for(int i = 0 ; i < C ; i++) {
			height[i] = sc.nextInt();	
		}
		
		int result = 0; 
		
		for(int i = 0 ; i < block[P].length ; i++) {
			for(int j = 0 ; j < C - block[P][i].length + 1 ; j++) {
				int gap = height[j] - block[P][i][0];
				boolean possible = true;
				
				for(int k = 1 ; k < block[P][i].length ; k++) {
					if(gap != height[j+k] - block[P][i][k]) {
						possible = false;
						break;
					}
				}
				if(possible)
					result++;
			}
		}
		
		System.out.println(result);
	}

}
