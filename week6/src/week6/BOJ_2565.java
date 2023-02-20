package week6;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BOJ_2565 {

	static int[][] line;
	static int[] dp;

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		int result = 0;
		int N = sc.nextInt();
		
		line = new int[N][2];
		dp = new int[N];
		
		for(int i = 0 ; i < N ; i++) {
			line[i][0] = sc.nextInt();	//A 전봇대 
			line[i][1] = sc.nextInt();	//B 전봇대 
		}
		
		// 첫번째 원소(A 전봇대) 기준으로 오름차순 정렬 
		Arrays.sort(line, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		
		// i번째 A 전봇대 가준으로 연결 가능한 전선 개수 탐색 및 최댓값 찾기 
		for(int i = 0 ; i < N ; i++) {
			result = Math.max(result, findLine(i));
		}
		
		System.out.println(N - result);	// N - 최댓값 = 제거해야하는 전선의 개수 
		
		
	}
	
	
	public static int findLine(int n) {
		// 아직 탐색하지 않았으면 
		if(dp[n] == 0){
			
			// 최솟값 1로 초기화 + 방문표시 
			dp[n] = 1;
			
			//A 전봇대의 N번째 선과 그 이후 선 비교 
			for(int i = n+1 ; i <dp.length ; i++) {
				
				
				// A 전봇대의 N번째 전선이 연결되어있는 B전봇대보다 
				// A의 i 번째 전봇대의 전선이 이어진 B 전봇대가 뒤에 있으면 전선 설치 가능 
				if(line[n][1] < line[i][1]) {
					dp[n] = Math.max(dp[n], findLine(i) + 1);
				}
			}
		}
		
		return dp[n];
	}

}
