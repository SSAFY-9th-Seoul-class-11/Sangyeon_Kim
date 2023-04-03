package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1753 {
	
	static int V, E, K;
	static ArrayList<Node>[] graph;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken());	//노드의 개수
		E = Integer.parseInt(st.nextToken());	//간선의 개수
		
		K = Integer.parseInt(br.readLine());	//시작 노드
		
		graph = new ArrayList[V+1];
		
		for(int i = 0 ; i <= V ; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i = 0 ; i < E ; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());	//출발
			int v = Integer.parseInt(st.nextToken());	//도착
			int w = Integer.parseInt(st.nextToken());	//가중치
			graph[u].add(new Node(v, w));
		}
		
		Dijkstra(V, K);	//노드 개수, 출발 노드 매개변수로 넘김
	}
	
	public static void Dijkstra(int V, int K) {
		boolean[] visited = new boolean[V+1];
		int[] distance = new int[V+1];
		int INF = Integer.MAX_VALUE;
		
		Arrays.fill(distance, INF);
		distance[K] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(K, 0));
		
		while(!pq.isEmpty()) {
			int curr = pq.poll().idx;
			
			if(visited[curr])
				continue;
			
			visited[curr] = true;
			
			for (Node next : graph[curr]) {
				if(distance[next.idx] > distance[curr] + next.cost) {
					distance[next.idx] = distance[curr] + next.cost;
					
					pq.offer(new Node(next.idx, distance[next.idx]));
				}
				
			}
		}
		
		for(int i = 1 ; i <= V ; i++) {
			if(distance[i] == INF)
				System.out.println("INF");
			else
				System.out.println(distance[i]);
		}
		
	}
	
	public static class Node implements Comparable<Node>{
		int idx, cost;

		public Node(int idx, int cost) {
			super();
			this.idx = idx;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.cost, o.cost);
		}
		
		
	}

}