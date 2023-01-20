package week2;

import java.util.Scanner;

public class Solution_1220 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = 10;
		
		
		for(int tc = 1; tc <= T ; tc++) {
			int[][] arr = new int[100][100];
			int result = 0;
			int N = sc.nextInt();
			
			for(int i = 0 ; i < N; i++) {
				for(int j = 0 ; j < N ; j++) {
					arr[i][j] = sc.nextInt();	//1은 N극을 나타내는 자성체, 2는 S극을 나타내는 자성체
				}
			}
			
			for(int j = 0; j < N; j++) {
				int Npolo = 0;
				for(int i = 0 ; i < N ; i++) {
					if(arr[i][j] == 1) {
						Npolo = 1;
					}else if(arr[i][j] == 2 && Npolo == 1) {
						result++;
						Npolo = 0;
					}
				}
			}
			
			System.out.printf("#%d %d\n", tc, result);
			
		}
		
		sc.close();

	}

}
