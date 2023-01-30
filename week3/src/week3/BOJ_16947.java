package week3;

import java.io.IOError;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_16947 {

	static int N;
	static List<Integer>[] adj;
	static boolean[] visited;
	static boolean[] isCycle;
	static int[] distance;
	
	static boolean dfs(int start, int i, int cnt) {
		for(int next : adj[i]) {
			if(next == start) {		// 바로 돌아오는 경우 확인 
				if(cnt > 1) return isCycle[i] = true;
				else continue;
			}
			
			if(isCycle[next] ||isCycle[i] || visited[next]) continue;
			visited[next] = true;
			isCycle[i] = dfs(start, next, cnt+1);
		}
		return isCycle[i];
	}
	
	static void checkCycle() {
		isCycle = new boolean[N+1];
		
		for(int i = 1 ; i <= N ; i++) {
			if(!isCycle[i]) {
				visited = new boolean[N+1];
				dfs(i, i, 0);
			}
		}
	}
	
	static void searchRoute(int i ) {
		for(int next : adj[i]) {
			if(isCycle[next] ||distance[next] > 0) {
				continue;
			}
			distance[next] = distance[i]+1;
			searchRoute(next);
		}
	}
	
	static void getDistance() {
		distance = new int[N+1];
		visited = new boolean[N+1];
		
		for(int i = 1 ; i <= N ; i++) {
			if(isCycle[i] && adj[i].size() > 2) {
				searchRoute(i);
			}
		}
		for(int i = 1 ; i <= N ; i++) {
			System.out.print(distance[i] + " ");
		}
	}
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		adj = new List[N+1];
		for(int i = 1 ; i <= N ; i++	) {
			adj[i] = new ArrayList<>();
		}
		for(int i = 0 ; i < N ; i++) {
			int v = sc.nextInt();
			int u = sc.nextInt();
			
			adj[v].add(u);
			adj[u].add(v);
		}
		checkCycle();
		getDistance();
		
	}

}
