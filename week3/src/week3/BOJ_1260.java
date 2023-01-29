package week3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1260 {

	static int[][] matrix;
	static int[] visited;
	
	static int n;
	static int m;
	static int v;
	
	static Queue<Integer> q = new LinkedList<>();
	
	static StringBuilder sb = new StringBuilder();
	
	public static void dfs(int v) {
		visited[v] = 1;
		System.out.print(v +" ");
		for(int i = 1 ; i < n+1 ; i++) {
			if(visited[i] == 0 && matrix[v][i] == 1) {
				dfs(i);
			}
		}
	}
	
	public static void bfs(int v) {
		q.add(v);
		visited[v] = 0;	//dfs에서 visited를 1로 설정했기 때문 
		
		while(!q.isEmpty()) {
			
			v = q.poll();
			System.out.print(v +" ");
			
			for(int i = 1 ; i <= n ; i++) {
				if(visited[i] == 1 && matrix[v][i] == 1) {
					q.add(i);
					visited[i] = 0;
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();	// 정점의 개수 
		m = sc.nextInt();	// 간선의 개수 
		v = sc.nextInt();	// 탐색 시작 번호 
		
		matrix = new int[n+1][n+1];
		visited = new int[n+1];
		
		for(int i = 0 ; i < m ; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			matrix[a][b] = matrix[b][a] = 1;
		}
		
		dfs(v);
		System.out.println();
		bfs(v);
		
		
	}

}
