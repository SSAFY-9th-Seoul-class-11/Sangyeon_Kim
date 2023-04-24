package week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20040_사이클게임  {

	static int N, M, ans;
	static int[] line;
	static boolean isCycle = false;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		ans = 0;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		line = new int[N];
		for(int i = 0 ; i < N; i++) {
			line[i] = i;
		}
		
		for(int i = 0 ; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(find(a) == find(b)) {
				ans = i + 1;
				isCycle = true;
				break;
			}
			
			union(a, b);
			
		}	
			
		//사이클이 있으면 ans 출력, 사이클 없으면 0 출력  
		System.out.println(isCycle? ans : 0);
		

	}
	
	public static int find(int x) {
		if(x == line[x])
			return x;
		else {
			line[x] = find(line[x]);
			return line[x];
		}
			
		
	}
	
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x < y) {
			line[y] = x;
		}
		else {
			line[x] = y;
		}
	}

}
