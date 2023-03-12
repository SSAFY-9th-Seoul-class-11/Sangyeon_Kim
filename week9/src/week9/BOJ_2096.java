package week9;

import java.util.Scanner;

public class BOJ_2096 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[][] arr = new int[N+1][3];
		int[][] max_result = new int[N+1][3];
		int[][] min_result = new int[N+1][3];
		
		for(int i = 1 ; i <= N ; i++) {
			for(int j = 0 ; j < 3 ; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
//		for(int i = 0 ; i < 3 ; i++)
//			min_result[0][i] = 10;
		
		for(int i = 1 ; i <= N ; i++) {
			for(int j = 0 ; j < 3 ; j++) {
				max_result[i][0] = max(max_result[i-1][0], max_result[i-1][1]) + arr[i][0];
				max_result[i][1] = max(max_result[i-1][0], max(max_result[i-1][1], max_result[i-1][2])) + arr[i][1];
				max_result[i][2] = max(max_result[i-1][1], max_result[i-1][2]) + arr[i][2];
			}
		}
		
		
		for(int i = 1 ; i <= N ; i++) {
			for(int j = 0 ; j < 3 ; j++) {
				min_result[i][0] = min(min_result[i-1][0], min_result[i-1][1]) + arr[i][0];
				min_result[i][1] = min(min_result[i-1][0], min(min_result[i-1][1], min_result[i-1][2])) + arr[i][1];
				min_result[i][2] = min(min_result[i-1][1], min_result[i-1][2]) + arr[i][2];
			}
		}
		
		
		System.out.println(max(max_result[N][0], max(max_result[N][1], max_result[N][2]))+" "+min(min_result[N][0], min(min_result[N][1], min_result[N][2])));
		
		
	}
	
	private static int max(int x, int y) {
		return x > y ? x : y;
	}
	
	private static int min(int x, int y) {
		return x > y ? y : x;
	}
	
}


