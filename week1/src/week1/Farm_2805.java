package week1;

import java.util.Scanner;

public class Farm_2805 {

	public static void main(String[] args) {
			
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1 ; tc <= T ; tc++ ) {
			int N = sc.nextInt();
			int result = 0;
			int[][] map = new int[N][N];
			
			//배열 입력
			for(int i = 0 ; i < N ; i++){
				String str = sc.next();
				for(int j = 0 ; j < str.length() ; j++) {
					map[i][j] = str.charAt(j) - '0';
				}
			}
			
			//상단 삼각형 탐색
			for(int i = 0; i < N/2 ; i++) {
				for(int j = N/2 - i ; j <= N/2 + i ; j++) {
					result += map[i][j];
				}
			}
			
			//하단 삼각형 탐색
			for(int i = N/2 ; i >= 0 ; i--) {
				for(int j = N/2 - i ; j <= N/2 + i ; j++) {
					result += map[N - i - 1][j];
				}
			}
			
			System.out.printf("#%d %d\n", tc, result);
		}
	
	}
}
