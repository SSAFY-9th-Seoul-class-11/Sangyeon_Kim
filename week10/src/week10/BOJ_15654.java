package week10;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_15654 {

	static int n, m, arr[], answer[];
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		arr = new int[n];
		answer = new int[n];
		visited = new boolean[n];
		
		
		for(int i = 0 ; i < n ; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);

		dfs(0);
		
		System.out.println(sb);
		

	}
	
	private static void dfs(int depth) {
		
		
		if(depth == m) {
			for(int i = 0 ; i < m ; i++) {
				sb.append(answer[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 0 ; i < n ; i++) {
			if(!visited[i]) {
				visited[i] = true;
				answer[depth] = arr[i];
				dfs(depth+1);
				visited[i] = false;
			}
		}
		
	}

}
