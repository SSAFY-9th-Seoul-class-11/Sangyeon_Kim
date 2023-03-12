package week8;

import java.util.Scanner;

public class BOJ_3019 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int C = sc.nextInt();
		int P = sc.nextInt() -1;
		
		int[][][] block = //각 블럭 및 회전 경우에 따른 바닥과의 차이 저
				{{{0}, {0,0,0,0}}, 
				{{0, 0}}, 
				{{0,0,1}, {1, 0}}, 
				{{1, 0, 0,}, {0, 1}}, 
				{{0,0,0}, {1, 0}, {1, 0, 1}, {0, 1}}, 
				{{0,0,0},{0,0},{0,1,1},{2,0}}, 
				{{0,0,0},{0,0},{1,1,0},{0,2}}};
		
		int[] height = new int[C];
		for(int i = 0 ; i < C ; i++) {
			height[i] = sc.nextInt();	// 기존에 깔려있는 블록 높이 입력 
		}
		
		int result = 0; 
		
		for(int i = 0 ; i < block[P].length ; i++) {	// 선택한 블록의 회전 개수만큼 수행 
			for(int j = 0 ; j < C - block[P][i].length + 1 ; j++) {	//주어진 너비에 블록을 넣을 수 있는 경우의 수만큼 수
				int gap = height[j] - block[P][i][0];	
				boolean possible = true;
				
				for(int k = 1 ; k < block[P][i].length ; k++) {	// 블록을 놨을때 아래 바닥면과의 높이 비
					if(gap != height[j+k] - block[P][i][k]) {	// gap이 현재 위치의 높이와 다르면 안된
						possible = false;
						break;
					}
				}
				if(possible)  // 끝까지 돌았는데도 됐으면 result 1 증
					result++;
			}
		}
		
		System.out.println(result);
	}

}
