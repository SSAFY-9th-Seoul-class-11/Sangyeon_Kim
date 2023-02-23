package week7;

import java.util.Scanner;

public class BOJ_17070 {

	
	static int[][] map;
	static int N, answer;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		map = new int[N+1][N+1];
		
		for(int i = 1 ; i <= N ; i++) {
			for(int j = 1 ; j <= N ; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		answer = 0;
		dfs(1,2,0); // 파이프의 끝 부분 좌표만 고려 
		System.out.println(answer);
	}
	
	private static void dfs(int x, int y, int dir) {	// (N,N)끝까지 도착하면 answer 1증가.
		if(x == N && y == N) {
			answer++;
			return;
		}
		
		switch(dir) {
		case 0:	// 파이프가 가로일 때 - 가로 / 대각선 이동 
			if(y + 1 <= N && map[x][y+1] == 0)
				dfs(x, y+1, 0);
			break;
		case 1:	// 파이프가 세로일 때 - 세로 / 대각선 이동 
			if(x + 1 <= N && map[x+1][y]== 0)
				dfs(x+1, y, 1);
			break;
		case 2: // 파이프가 대각선일 때 - 가로 / 세로 / 대각선 이동 
			if(y+1 <= N && map[x][y+1] == 0)
				dfs(x, y+1, 0);
			if(x+1 <= N && map[x+1][y] == 0)
				dfs(x+1, y, 1);
			break;
		}
		// 대각선은 무조건 탐색하니까 뺴 
		if(x+1 <= N && y+1 <= N && map[x+1][y+1] == 0 && map[x+1][y] == 0 && map[x][y+1] == 0)	// 대각선은 차지하는 4칸 모두 벽 없는지 확인해야함. 
			dfs(x+1, y+1, 2);
		
	}

}
