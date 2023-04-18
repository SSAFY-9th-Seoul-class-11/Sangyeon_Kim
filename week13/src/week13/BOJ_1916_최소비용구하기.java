package week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1916_최소비용구하기 {

	static int INF = 100000000;
	static boolean[] visited;
	static int[][] graph;
	static int N, M, dijkstra[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N  = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		graph = new int[N][N];
		visited = new boolean[N];
		
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				if(i == j) {
					graph[i][j] = 0;
					continue;
				}
				graph[i][j] = INF;
			}
		}
		
		
		StringTokenizer st;
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()) - 1;
			int d = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken());
			
			graph[s][d] = Math.min(graph[s][d], c);
		
		}
		
		st = new StringTokenizer(br.readLine());
		
		int start = Integer.parseInt(st.nextToken()) - 1;
		int end = Integer.parseInt(st.nextToken()) - 1;
		
		dijkstra = graph[start].clone();
		
		visited[start] = true;
		
		for(int i = 1; i < N ; i++) {
			int idx = move();
			visited[idx] = true;
			
			for(int j = 0 ; j < N ; j++) {
				dijkstra[j] = Math.min(dijkstra[j], dijkstra[idx] + graph[idx][j]);
			}
		}
		
		System.out.println(dijkstra[end]);
		

	}
	
	public static int move() {
		int min_idx = 0;
		int min = Integer.MAX_VALUE;
		
		for(int i = 0 ; i < N ; i++) {
			if(visited[i])
				continue;
			
			if(min > dijkstra[i]) {
				min = dijkstra[i];
				min_idx = i;
			}
		}
		
		return min_idx;
	}

}
