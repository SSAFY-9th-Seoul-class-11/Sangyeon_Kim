package week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_12852_1로만들기2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		int[] dp = new int[N+2];
		int[] trace = new int[N+1];
		
		dp[1] = 0;
		trace[1] = 1;
		
		for(int i = 2 ; i <= N ; i++) {
			dp[i] = dp[i-1] + 1;   
			trace[i] = i-1;
			
			if(i % 2 == 0 && dp[i] > dp[i/2] + 1) {
				dp[i] = dp[i/2] + 1;
				trace[i] = i/2;
			}
			
			if(i % 3 == 0 && dp[i] > dp[i/3] + 1) {
				dp[i] = dp[i/3] + 1;
				trace[i] = i/3;
			}
		
		}
		
		int num = dp[N];
		System.out.println(num);
		
		int idx = N;
		for(int i = 0 ; i <= num ; i++) {
			sb.append(idx+" ");
			idx = trace[idx];
		}
		System.out.println(sb);

	}

}
