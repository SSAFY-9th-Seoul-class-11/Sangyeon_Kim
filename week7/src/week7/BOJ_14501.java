package week7;

import java.util.Scanner;

public class BOJ_14501 {

	static int N;
	static int[] T, P, dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		T = new int[N];
		P = new int[N];
		
		for(int i = 0 ; i < N; i++) {
			T[i] = sc.nextInt();	// 상담 진행일 
			P[i] = sc.nextInt();	// 받을 수 있는 금액 
		}
		
		dp = new int[N+1];	//n일차에 얻을 수 있는 최대 수익 
		
		for(int i = 0 ; i <N ; i++) {
			if(i + T[i] <= N)
				dp[i +T[i]] = Math.max(dp[i+T[i]], dp[i]+P[i]);

			dp[i+1] = Math.max(dp[i], dp[i+1]);
		}
		
		System.out.println(dp[N]);

	}

}
