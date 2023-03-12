package week9;

import java.util.Scanner;

public class BOJ_1149 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[N+1][3];
		int[][] dp = new int[N+1][3];
		
		for(int i = 1 ; i <= N ; i++) {
			for(int j = 0 ; j < 3 ; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		
		for(int i = 1 ; i <= N ; i++) {	// 바로 윗칸(같은 색)을 제외한 이전 dp 배열 두 칸 중에 작은 값 + 현재 배열 
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + arr[i][0];	
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + arr[i][1];
			dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + arr[i][2];
		}
		
			
		System.out.println(Math.min(dp[N][0], Math.min(dp[N][1], dp[N][2])));
		
	}

}
