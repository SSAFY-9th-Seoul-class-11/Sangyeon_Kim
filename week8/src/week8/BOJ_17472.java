package week8;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_17472 {

	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static int N, M;	//N: 세로 크기, M: 가로 크기
	static int[][] map;
	static boolean[][] visited;
	static int[] parent;
	static ArrayList<Node>[] list;
	static PriorityQueue<Mst_Node> pq;
	
	
	public static class Node{
		int x, y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		} 
	}
	
	public static class Mst_Node implements Comparable<Mst_Node> {
		int n1, n2, distance;

		public Mst_Node(int n1, int n2, int distance) {
			super();
			this.n1 = n1;
			this.n2 = n2;
			this.distance = distance;
		}

		@Override
		public int compareTo(Mst_Node o) {
			return this.distance - o.distance;
		}
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		map = new int[N][M];
		
		for(int i = 0 ; i < N ; i++) {	// 섬 입력 
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		list = new ArrayList[7];	// 섬 개수 최대 6개이므로 크기 7 선언
		visited = new boolean[N][M];
		int cnt = 1;
		
		
		// bfs로 탐색하면서 섬마다 숫자 부여 
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				if(!visited[i][j] && map[i][j] == 1) {
					list[cnt] = new ArrayList<>();
					bfs(i, j, cnt);
					cnt++;
				}
			}
		}
		
		//섬 연결방법 구하기
		pq = new PriorityQueue<>();
		for(int i = 1 ; i < cnt ; i++) {
			for(int j = 0 ; j < list[i].size() ; j++) {
				Node island = list[i].get(j);
				for(int k = 0 ; k < 4 ; k++) {
					findBridge(island.x, island.y, i, k, -1);
				}
			}
		}
		
		System.out.println(kruskal(cnt));
		
	}
	
	private static int kruskal(int count) {
		parent = new int[count];
		for(int i = 1 ; i < count ; i++) {
			parent[i] = i;
		}
		
		boolean[] link = new boolean[count];
		int result = 0;
		int bridge = 0;
		
		while(!pq.isEmpty()) {
			Mst_Node curr = pq.poll();
			
			int p1 = find(curr.n1);
			int p2 = find(curr.n2);
			
			if(p1 != p2) {
				union(p1, p2);
				link[curr.n1] = true;
				link[curr.n2] = true;
				result += curr.distance;
				bridge++;
			}
		}
		
		if(result == 0) return -1;
		if(bridge != count -2) return -1;
		return result;
	}

	private static int find(int node) {
		if(parent[node] == node) return node;
		
		else return parent[node] = find(parent[node]);
	}
	
	private static void union(int a, int b) {
		parent[a] = b;
	}

	private static void findBridge(int x, int y, int count, int dir, int len) {
		if(map[x][y] != 0 && map[x][y] != count) {	// 다른 섬을 찾았을 
			if(len >= 2)
				pq.offer(new Mst_Node(count, map[x][y] , len));
			return;
		}
		
		int nx = x +dx[dir];
		int ny = y + dy[dir];
		if(nx < 0 || nx >= N || ny < 0 || ny >= M)
			return;
		if(map[nx][ny] == count)
			return;
		findBridge(nx, ny, count, dir, len+1);
		
	}

	private static void bfs(int x, int y, int count) {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(x, y));
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			Node curr = q.poll();
			
			map[curr.x][curr.y] = count;
			list[count].add(new Node(curr.x, curr.y));
			
			for(int d = 0 ; d < 4 ; d++) {
				int nx = curr.x + dx[d];
				int ny = curr.y + dy[d];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= M)
					continue;
				if(visited[nx][ny] || map[nx][ny] != 1 )
					continue;
				
				visited[nx][ny] = true;
				q.offer(new Node(nx, ny));
			}
		}
	}
	

}
