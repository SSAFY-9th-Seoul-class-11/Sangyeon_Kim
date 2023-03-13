package week9;

import java.util.Scanner;

public class BOJ_15652 {

	static int n, m, arr[];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[m];
		
		dfs(1,0);
		
		System.out.println(sb);

	}
	
	private static void dfs(int num, int depth) {
		
		if(depth == m) {
			for(int i = 0 ; i < m ; i++) {
				sb.append(arr[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = num ; i <= n ; i++) {
			arr[depth] = i	;
			dfs(i, depth+1);
		}
	}

}
