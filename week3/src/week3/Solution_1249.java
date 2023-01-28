package week3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_1249 {
	
	public static class Position{
		public int x;
		public int y;
		
		Position(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};	//좌 우 상 하 
		
		for(int tc = 1 ; tc <= T ; tc++) {
			int N = sc.nextInt();
			int[][] map = new int[N][N];
			int[][] visited = new int[N][N];	// 방문한 칸은 1로 표시 	
			int[][] result = new int[N][N];		// 시작 칸은 0 
			
			Queue<Position> q = new LinkedList<>();
			
			for(int i = 0 ; i < N ; i++) {	
				String input = sc.next();
				for(int j = 0 ; j < N ; j++) {
					map[i][j] = input.charAt(j) - '0';
					result[i][j] = -1;
				}
			}
			
			result[0][0] = 0;
			visited[0][0] = 1;
			
			q.add(new Position(0, 0));
			
			while(!q.isEmpty()) {
				Position position = q.poll();
				int x = position.x;
				int y = position.y;
			
				for(int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					
					if(nx >= 0 && ny >= 0 && nx < N && ny < N) {
						if(visited[nx][ny] == 0) {
							q.add(new Position(nx, ny));
							visited[nx][ny] = 1;
							result[nx][ny] = result[x][y] + map[nx][ny];
						}
						else {
							if(result[x][y] + map[nx][ny] < result[nx][ny]) {
								result[nx][ny] = result[x][y] + map[nx][ny];
								q.add(new Position(nx, ny));
							}
						}
					}
				}
			}
			System.out.printf("#%d %d\n",tc, result[N-1][N-1]);

		}
	}
}
