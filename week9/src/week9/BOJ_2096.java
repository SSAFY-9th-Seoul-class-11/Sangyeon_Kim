package week9;

import java.util.Scanner;

public class BOJ_2096 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[][] arr = new int[N+1][3];
		int[][] max_result = new int[N+1][3];	//최대 점수를 저장할 DP 배열 
		int[][] min_result = new int[N+1][3];	//최소 점수를 저장할 DP 배열 
		
		for(int i = 1 ; i <= N ; i++) {	// 점수 입력 받기 
			for(int j = 0 ; j < 3 ; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		
		for(int i = 1 ; i <= N ; i++) {
			for(int j = 0 ; j < 3 ; j++) {	//윗 줄에서 접근할 수 있는 부분 중에서 더 큰 점수 + 현재 위치의 점수를 max_result에 저장 
				max_result[i][0] = max(max_result[i-1][0], max_result[i-1][1]) + arr[i][0];
				max_result[i][1] = max(max_result[i-1][0], max(max_result[i-1][1], max_result[i-1][2])) + arr[i][1];
				max_result[i][2] = max(max_result[i-1][1], max_result[i-1][2]) + arr[i][2];
			}
		}
		
		
		for(int i = 1 ; i <= N ; i++) {
			for(int j = 0 ; j < 3 ; j++) {	// 윗 줄에서 접근할 수 있는 부분 중에서 더 작은 점수 + 현재 위치의 점수를 min_result에 저장 
				min_result[i][0] = min(min_result[i-1][0], min_result[i-1][1]) + arr[i][0];
				min_result[i][1] = min(min_result[i-1][0], min(min_result[i-1][1], min_result[i-1][2])) + arr[i][1];
				min_result[i][2] = min(min_result[i-1][1], min_result[i-1][2]) + arr[i][2];
			}
		}
		
		// 각 배열의 가장 마지막줄 3개의 숫자를 비교하여 최댓값과 최솟값 출력 
		System.out.println(max(max_result[N][0], max(max_result[N][1], max_result[N][2]))+" "+min(min_result[N][0], min(min_result[N][1], min_result[N][2])));
		
		
	}
	
	private static int max(int x, int y) {
		return x > y ? x : y;
	}
	
	private static int min(int x, int y) {
		return x > y ? y : x;
	}
	
}


