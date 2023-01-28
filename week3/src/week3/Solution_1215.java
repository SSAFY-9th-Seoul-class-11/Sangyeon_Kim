package week3;

import java.util.Scanner;

public class Solution_1215 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = 10;
		
		for(int tc = 1 ; tc <= T ; tc++ ) {
			
			int result = 0;
			int l = sc.nextInt();
			char[][] arr = new char[8][8];
			
			for(int i = 0 ; i < 8 ; i++) {
				String s = sc.next();
				for(int j = 0 ; j  < 8 ; j++ ) {
					arr[i][j] = s.charAt(j);
				}
			}
			
			// 가로 회문 확인 
			for(int i = 0 ; i < 8 ; i++ ) {
				for(int j = 0 ; j < 8 - l + 1 ; j++ ) {
					boolean same = true;
					for(int k = 0 ; k < l/2 ; k++ ) {
						if(arr[i][j+k] != arr[i][j+l-k-1]) {
							same = false;
						}
					}
					if(same) {
						result++;
					}
				}
			}
			
			// 세로 회문 확인 
			for(int i = 0 ; i < 8 ; i++ ) {
				for(int j = 0 ; j < 8 - l + 1 ; j++ ) {
					boolean same = true;
					for(int k = 0 ; k < l/2 ; k++ ) {
						if(arr[j+k][i] != arr[j+l-k-1][i]) {
							same = false;
						}
					}
					if(same) {
						result++;
					}
				}
			}
			
			System.out.printf("#%d %d\n", tc, result);
		}
	}

}
