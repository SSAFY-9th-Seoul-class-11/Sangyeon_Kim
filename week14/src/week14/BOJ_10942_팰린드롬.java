package week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10942_팰린드롬 {
	
	static int N, M;
	static boolean[][] DP;
	static int[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N+1];
		DP = new boolean[N+1][N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		for(int i = 1; i <= N ; i++) {			
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		getDP();	//DP 배열 만들어
		
		M = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < M ; i++){
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			if(DP[s][e])
				sb.append("1\n");
			else
				sb.append("0\n");
		}
		
		System.out.println(sb);
		
	}

	public static void getDP() {
		//길이가 1일 때는 무조건 팰린드롬
		for(int i = 1 ; i <= N ; i++) {
			DP[i][i] = true;
		}
		
		//길이가 2일 때는 두 숫자가 같으면 팰린드롬
		for(int i = 1 ; i < N ; i++) {
			if(arr[i] == arr[i+1])
				DP[i][i+1] = true;
		}
		
		//길이가 3 이상일 때는 시작점과 끝점이 같으면서 두 점을 제외한 나머지 점이 팰린드롬이면 팰린드롬
		for(int i = 2; i < N ; i++) {
			for(int j = 1 ; j <= N - i ; j++) {
				if(arr[j] == arr[j+i] && DP[j+1][j+i-1]) {
					DP[j][j+i] = true;
				}
			}
		}
	}
	
}
