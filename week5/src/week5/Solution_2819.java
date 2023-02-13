package week5;

import java.util.HashSet;
import java.util.Scanner;


public class Solution_2819 {

	static int N;
	static HashSet<String> set;	//중복 제거를 위해 HashSet 사용 
	static int[][] map;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		N = 4;
		
		for(int tc = 1 ; tc <= T ; tc++) {
			map = new int[N][N];
			set = new HashSet<>();
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < N ; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			
			for(int i = 0 ; i < N ; i++) { 
				for(int j = 0 ; j < N ; j++) {
					dfs(i,j,0,""+map[i][j]);
				}
			}
			System.out.println("#"+tc+" "+set.size());
		}
	}

	
	private static void dfs(int i, int j, int depth, String str) {
		if(depth == 6) {	//7자리 수가 완성되면 Set에 넣고 리턴 
			set.add(str);
			return;
		}
		for(int dir = 0 ; dir < dc.length; dir++) {	// map의 좌우상하 탐색해서 범위 안에 들어가면 str에 추가 
			int nr = i + dr[dir];	
			int nc = j + dc[dir];
			if(0 <= nr && nr < N && 0 <= nc && nc < N) {
				dfs(nr, nc, depth+1, str+map[nr][nc]);
			}
		}
	}
	
}
