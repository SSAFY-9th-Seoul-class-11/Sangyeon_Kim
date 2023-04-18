package week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2623_음악프로그램 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] edgeCnt = new int[N+1];
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		
		for(int i = 0 ; i < N+ 1 ; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			
			int num = Integer.parseInt(st.nextToken());	//한 pd가 담당하는 가수의 수 
			int before = Integer.parseInt(st.nextToken());
			for(int j = 1 ; j < num ; j++) {
				int singer = Integer.parseInt(st.nextToken());
				graph.get(before).add(singer);
				edgeCnt[singer]++;
				
				before = singer;
				
			}
			
		}
		
		Queue<Integer> q = new ArrayDeque<>(); 
		ArrayList<Integer> result = new ArrayList<>();
		for(int i = 1 ; i <= N ; i++) {
			if (edgeCnt[i] == 0) {
				q.offer(i);
			}
		}
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			
			result.add(curr);
			
			for (int next : graph.get(curr)) {
				edgeCnt[next]--;
				
				if(edgeCnt[next] == 0) {
					q.offer(next);
				}
			}
			
		}
		
		StringBuilder sb = new StringBuilder();
		boolean isCycle = false;
		if(result.size() != N ) {
			isCycle = true;
		}else {
			for(int i = 0 ; i < result.size() ; i++) {
				sb.append(result.get(i)).append("\n");
			}
		}
		
		System.out.print(isCycle? 0 : sb.toString());
		
		
	}

}
