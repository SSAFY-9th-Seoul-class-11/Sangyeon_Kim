package week14;

import java.util.Scanner;

public class BOJ_17404_RGB거리2{

	private static final int INF = 1000 * 1000;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int ans = INF;
		
		
		int[][] dp = new int[N+1][3];
		int[][] arr = new int[N+1][3];
		
		for(int i = 1 ; i <= N ; i++) {
			for(int j = 0 ; j < 3 ; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		for(int k = 0 ; k < 3 ; k++) {
			for(int i = 0 ; i < 3 ; i++) {
				if(i == k)
					dp[1][i] = arr[1][i];
				else
					dp[1][i] = INF;
			}
			
			
			for(int i = 2 ; i <= N ; i++) {
				dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + arr[i][0];
				dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + arr[i][1];
				dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + arr[i][2];
			}
			
			for(int i = 0 ; i < 3; i++) {
				if(i != k)
					ans = Math.min(ans, dp[N][i]);
			}
			
		}
	
		System.out.println(ans);
	}
	
	

}
