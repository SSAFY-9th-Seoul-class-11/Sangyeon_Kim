import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11404_플로이드 {

	static int N, M;
	static int[][] map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		int INF = 10000000;
		
		map = new int[N][N];
		
		for(int i = 0 ; i < N ; i++) {
			Arrays.fill(map[i], INF);
		}
		
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			map[s - 1][e - 1] = Math.min(map[s-1][e-1], cost);
			
		}
		
		//플루이드 - 워셜 빙빙
		
		for(int k = 0 ; k < N ; k++) {
			for(int i = 0 ; i < N ; i++) {
				for(int j = 0 ; j < N ; j++) {
					if(i==j)
						map[i][j] = 0;
					if(map[i][j] > map[i][k] + map[k][j]) {
						map[i][j] = map[i][k] + map[k][j];
					}
					
				}
			}
		}
		
		
		
		
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				if(map[i][j] == INF)
					map[i][j] = 0;
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		

	}

}