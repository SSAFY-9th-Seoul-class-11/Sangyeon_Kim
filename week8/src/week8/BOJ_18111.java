package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_18111 {

	static int N, M, B;	// N: 세로, M: 가로, B: 보유하고 있는 블록 개수
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		int min = 256;
		int max = 0;
		
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(min > map[i][j] ) min = map[i][j];
				if(max < map[i][j]) max = map[i][j];
			}
		}
		
		int time = Integer.MAX_VALUE;
		int height = 0;
		
		for(int i = min; i <= max ; i++) {
			int cnt = 0;
			int block = B;
			
			for(int j = 0 ; j < N ; j++) {
				for(int k = 0 ; k < M ; k++) {
					if(i < map[j][k]) {
						cnt += ((map[j][k] - i) * 2);	// 블록 제거시간은 2초
						block += map[j][k] - i;
					}
					else {
						cnt += (i - map[j][k]);
						block -= (i - map[j][k]);
					}
				}
			}
			
			if(block < 0)
				break;
			if(time >= cnt) {
				time = cnt;
				height = i;
			}
			
		}
		
		System.out.println(time+" "+height);
		
		
		
		

	}

}