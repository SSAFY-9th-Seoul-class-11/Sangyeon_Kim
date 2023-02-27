package week7;

import java.util.Scanner;

public class BOJ_17046 {

	static int[][] map;
	static int[][] rotation;
	static int N, M;
	static boolean[] visited;
	static int[] result;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		int k = sc.nextInt();
		
		map = new int[N][M];
		
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		rotation = new int[k][3];
		for(int i = 0 ; i < k ; i++) {
			rotation[i][0] = sc.nextInt();
			rotation[i][1] = sc.nextInt();
			rotation[i][2] = sc.nextInt();
		}
		
		visited = new boolean[k];
		result = new int[k];
		permutation(0, k);	//회전 순서에 따라 결과가 바뀌기 때문에 순열 사용. 
		
		
		System.out.println(min);
		
	}

	private static void permutation(int idx, int k) {
		if(idx == k) {
			int[][] copy = new int[N][M];
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < M ; j++) {
					copy[i][j] = map[i][j];
				}
			}
			
			findMin(copy);
			return;
		}
		
		for(int i = 0 ; i < k ; i++) {
			if(visited[i] == false) {
				visited[i] = true;
				result[idx] = i;
				permutation(idx+1, k);
				visited[i] = false;
			}
		}
	}
	
	private static void findMin(int[][] copy) {
		for(int i = 0 ; i < result.length ; i++) {
			int lx = rotation[result[i]][0] - rotation[result[i]][2] -1;
			int ly = rotation[result[i]][1] - rotation[result[i]][2] -1;
			int rx = rotation[result[i]][0] + rotation[result[i]][2] -1;
			int ry = rotation[result[i]][1] + rotation[result[i]][2] -1;
			rotate(lx, ly, rx, ry, copy);	// lx, ly부터 rx, ry까지 회전
		}
		rowcal(copy); //회전한 배열의 최소 행값 계산
	}
	
	private static void rowcal(int[][] copy) {
		for(int i = 0 ; i < copy.length ; i++) {
			int sum = 0;
			for(int j = 0 ; j < copy[0].length ; j++) {
				sum += copy[i][j];
			}
			min = Math.min(min, sum	);
		}
	}
	
	private static void rotate(int lx, int ly, int rx, int ry, int[][] copy) {
		if(lx == rx && ly == ry) {
			return;
		}
		
		int[] temp = new int[3]; //배열 돌리면 모서리 부분 좌표 지워지니까 temp에 저장
		temp[0] = copy[lx][ry];
		temp[1] = copy[rx][ry];
		temp[2] = copy[rx][ly];
		
		// 오른쪽 회전
		for(int i = ry ; i > ly ; i--) {
			copy[lx][i] = copy[lx][i -1];
		}
		
		// 아래로 회전
		for(int i = rx ; i > lx ; i--) {
			if(i == lx + 1) 
				copy[i][ry] = temp[0];
			else
				copy[i][ry] = copy[i - 1][ry];
		}
		
		// 왼쪽 회전
		for(int i = ly ; i < ry ; i++	) {
			if(i == ry -1)
				copy[rx][i] = temp[1];
			else
				copy[rx][i] = copy[rx][i+1];	
		}
		
		// 위로 회전 
		for(int i = lx ; i < rx ; i++) {
			if(i == rx -1)
				copy[i][ly] = temp[2];
			else
				copy[i][ly] = copy[i+1][ly];
		}
		
		rotate(lx + 1 , ly + 1, rx - 1, ry - 1, copy);
	}
}
