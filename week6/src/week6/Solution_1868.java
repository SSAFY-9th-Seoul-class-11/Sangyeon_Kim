package week6;

import java.util.Scanner;

public class Solution_1868 {
	
	static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};	// 좌, 우, 상, 하, 좌상, 좌하, 우상, 우하  
	static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
	static char[][] map;
	static int n, result, cnt[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1 ; tc <= T ; tc++) {
			n = sc.nextInt();
			map = new char[n][n];
			cnt = new int[n][n];
			result = 0;
			
			for(int i = 0 ; i < n ; i++) {	// 지뢰밭 입력받기 
					map[i] = sc.next().toCharArray();
			}
			
			dfs();	// 주변 지뢰 개수 카운팅 
			
			//주변에 지뢰가 없는 곳부터 탐색 
			for(int i = 0 ; i < n ; i++) {
				for(int j = 0 ; j < n ; j++) {
					if(cnt[i][j] == 0 && map[i][j] != '*') {	// 현 위치가 지뢰가 아니고, 주변에 지뢰가 있으면 
						click(i, j);
						result++;
					}
				}
			}
			
			//클릭 안한 곳 탐색 
			for(int i = 0 ; i < n ; i++) {
				for(int j = 0 ; j < n ; j++) {
					if(cnt[i][j] > 0 && map[i][j] != '*') {	// 현 위치가 지뢰가 아니고, 주변에 지뢰가 있으면 
						click(i, j);
						result++;
					}
				}
			}
			
			System.out.printf("#%d %d\n",tc, result);
			
		}

	}
	
	public static void click(int x, int y) {
		int curr = cnt[x][y];
		
		cnt[x][y] = -1; // 방문 표시
		
		if(curr == 0) {
			for(int dir = 0 ; dir < 8 ; dir++) {	//주변에 지뢰가 없으면 주변탐색 진행 
				int nx = x + dx[dir];
				int ny = y + dy[dir];
				
				if(nx < 0 || nx >= n || ny < 0 || ny >= n || cnt[nx][ny] == -1 || map[nx][ny] == '*') // 범위를 벗어나거나, 클릭한 곳이거나 지뢰라면 넘어가 
					continue;
				
				click(nx,ny);
			}
		}
	}
	
	public static void dfs() {
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0; j < n ; j++) {
				if(map[i][j] == '.') {	// 클릭할 수 있으면 주변 지뢰 개수 탐색 
					int count = 0;
					for(int dir = 0 ; dir < 8 ; dir++ ) {
						int nx = i + dx[dir];
						int ny = j + dy[dir];
						
						if(nx < 0 || nx >= n || ny < 0 || ny >= n || map[nx][ny] != '*')	// 범위를 벗어나거나 지뢰가 아니면 패스 
							continue;
						count++;
					}
					
					cnt[i][j] = count;
				}
			}
		}
	}

}
