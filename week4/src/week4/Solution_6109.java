package week4;

import java.util.Scanner;

public class Solution_6109 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1 ; tc <= T; tc++) {
			int N = sc.nextInt();
			String command = sc.next();
			
			int[][] map = new int[N][N];
			int[][] result = new int[N][N];
			
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < N ; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			switch(command) {
			case "up":
				for(int j = 0 ; j < N ; j++) {	// 열 우선 탐색 
					for(int i = 0 ; i < N - 1 ; i++) {	// 위에서 아래로 
						if(map[i][j] == 0) {	// 현재 값이 0 이면 패스 
							continue;
						}
						
						int idx = i + 1;
						
						while(map[idx][j] == 0) {	// 비교할 값이 0이면 다음값, 
							if(idx == N-1) {	//열의 끝까지 탐색 
								break;
							}
							idx++;
						}
						
//						if(map[idx][j] == 0) {	// 비교할 다음 값이 0이면 패스 
//							continue;
//						}
						
						if(map[i][j] == map[idx][j]) {	// 다음 열과 합치고 해당칸은 0으로 만들어 
							map[i][j] += map[i][j];
							map[idx][j] = 0;
							i = idx;
						}
					}
					
					int cur = 0;
					for (int i = 0 ; i < N ; i++) {
						if(map[i][j]!= 0) {
							result[cur++][j] = map[i][j];
						}
					}
				}
				break;
				
			case "down":
				for(int j = 0 ; j < N ; j++) {
					for(int i = N - 1 ; i > 0  ; i--) {
						if(map[i][j] == 0) {
							continue;
						}
						
						int idx = i - 1;
						
						while(map[idx][j] == 0) {
							if(idx == 0) {
								break;
							}
							idx--;
						}
						
						if(map[idx][j] == 0) {
							continue;
						}
						
						if(map[i][j] == map[idx][j]) {
							map[i][j] += map[i][j];
							map[idx][j] = 0;
							i = idx;
						}
					}
					
					int cur = N-1;
					for (int i = N - 1 ; i >= 0 ; i--) {
						if(map[i][j]!= 0) {
							result[cur--][j] = map[i][j];
						}
					}
				}
				break;
				
			case "right":
				for(int i = 0 ; i < N ; i++) {
					for(int j = N-1 ; j > 0 ; j--) {
						if(map[i][j]== 0) {
							continue;
						}
						int idx = j-1;
						
						while(map[i][idx]== 0) {
							if(idx == 0)
								break;
							idx--;
					}
						if(map[i][idx] == 0)
							continue;
						if(map[i][j] == map[i][idx]) {
							map[i][j] += map[i][j];
							map[i][idx] = 0;
							j = idx;
						}
					}
					
					int cur = N-1;
					for(int j = N-1 ; j >= 0 ; j--) {
						if(map[i][j] != 0	) {
							result[i][cur--] = map[i][j];
						}
					}
				}
				break;
				
			case "left":
				for(int i = 0 ; i < N ; i++) {
					for(int j = 0 ; j < N-1 ; j++) {
						if(map[i][j]== 0) {
							continue;
						}
						int idx = j+1;
						
						while(map[i][idx]== 0) {
							if(idx == N - 1)
								break;
							idx++;
					}
						if(map[i][idx] == 0)
							continue;
						
						if(map[i][j] == map[i][idx]) {
							map[i][j] += map[i][j];
							map[i][idx] = 0;
							j = idx;
						}
					}
					
					int cur = 0;
					for(int j = 0 ; j < N ; j++) {
						if(map[i][j] != 0	) {
							result[i][cur++] = map[i][j];
						}
					}
				}
				
				break;
				
			}
			
			System.out.println("#" + tc);
			for(int[] is : result) {
				for (int i : is) {
					System.out.print(i + " ");
				}
				System.out.println();
			}
			
		}
	}

}
