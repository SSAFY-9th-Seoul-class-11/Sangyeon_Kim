package week3;

import java.util.Scanner;

public class BOJ_11724 {
	
	static int[][] graph = new int[1001][1001];
	static int n;
	static int m;
	static boolean[] visited = new boolean[1001];
	
	static void dfs(int index) {
		if(visited[index] == true) return;
		else {
			visited[index] = true;
			for(int i = 1 ; i <= n ; i++) {
				if(graph[index][i] == 1) {
					dfs(i);
				}
			}
		}
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();	// 정점의 개수 	
		m = sc.nextInt();	// 간선의 개수 	
		
		int a, b;
		for(int i = 0 ; i < m ; i++) {
			a = sc.nextInt();
			b = sc.nextInt();
			
			graph[a][b] = graph[b][a] = 1;
		}
		
		int result = 0;
		
		for(int i = 1; i <= n ; i++) {
			if(visited[i] == false) {
				dfs(i);
				result++;
			}
		}
		
		System.out.println(result);
	}

}
