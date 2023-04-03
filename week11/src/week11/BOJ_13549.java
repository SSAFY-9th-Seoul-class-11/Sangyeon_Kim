package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_13549 {

	static int n, k, visited[];
	final static int MAX = 100001;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		visited = new int[MAX];
		visited[n] = 1;
		
		
		if(n > k) {
			System.out.println(n - k);
		}else if(n==k) {
			System.out.println(0);
		}else {
			bfs();			
		}
		
		
	}

	public static void bfs() {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(n);
		int[] cnt = new int[MAX];
		
		while(!queue.isEmpty()) {
			int x = queue.poll();
			if(x == k) {
				System.out.println(cnt[x]);
				break;
			}
			for(int i = 0 ; i < 3 ; i++) {
				int nx;
				if(i==0) {
					nx = x * 2;
				}else if(i == 1) {
					nx = x - 1;
				}else {
					nx = x + 1;
				}
				
				if(nx >= 0 && nx <MAX && visited[nx] == 0) {
					queue.add(nx);
					
					visited[nx] = 1;
					if(i != 0) {
						cnt[nx] = cnt[x] + 1;
					}else {
						cnt[nx] = cnt[x];
					}
				}
			}
		}
	}
}