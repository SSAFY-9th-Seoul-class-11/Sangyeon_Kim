package week6;

import java.util.Scanner;

public class BOJ_9465 {
	
	static int[][] sticker;
	static int[][] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1 ; tc <= T ; tc++) {
			int n = sc.nextInt();
			
			sticker = new int[2][n+1];	// 스티커 점수 입력할 배열 
			dp = new int[2][n+1];	// 스티커 점수 합산 저장할 배열 
			
			for(int i = 0 ; i < 2 ; i++) {	// 스티커 점수 입력 
				for(int j = 1 ; j <= n ; j++) {
					sticker[i][j] = sc.nextInt();
				}
			}
			
			dp[0][1] = sticker[0][1];	// 각 줄의 첫번째 스티커 점수 합은 자기 자신 
			dp[1][1] = sticker[1][1];
			
			
			for(int i = 2 ; i <= n ; i++) {
				dp[0][i] = Math.max(dp[1][i-1], dp[1][i-2]) + sticker[0][i];	// 대각선 아래의 첫번쨰, 두번째 스티커 중 합이 더 큰거 + 현재 스티커 점수 더하기 
				dp[1][i] = Math.max(dp[0][i-1], dp[0][i-2]) + sticker[1][i];	// 얘는 대각선 위  
			}
			
			System.out.println(Math.max(dp[0][n], dp[1][n]));	// 윗줄이랑 아랫줄 중에서 점수합이 더 큰 값 출력 
		}
	}

}
