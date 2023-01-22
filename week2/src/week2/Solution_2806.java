package week2;
	// N Queen;
	// 열, 행, 각 대각선에 하나의 퀸만 존재해야 

import java.util.Scanner;

public class Solution_2806 {
	static int[] map;	// 1차원 배열로 체스판을 표현. map[2] = 2 ==> (2,2)에 퀸이 있다. 
	static int result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1 ; tc <= T ; tc++ ) {
			int N = sc.nextInt();
			map = new int[N];
			result = 0;
			
			nQueen(N, 0);
			
			System.out.printf("#%d %d\n", tc, result);
			
		}
		
	}
	
	static void nQueen(int n , int curr) {
		boolean isPossible;	// 놓을 수 있는지 여부 
		if(curr == n) {	// 모든 퀸을 다 놓았으면 
			result++;
			return;
		}
		
		for(int i = 0 ; i < n ; i++) {	// 해당 위치에 퀸을 놓을 수 있는지 확인 
			isPossible = true;
			for(int j = 0 ; j < curr ; j++ ) {
				if(map[j] == i || i == map[j]+(curr - j ) || i == map[j]-(curr - j)) {
					isPossible = false;
					break;
				}
			}
			if(isPossible) {
				map[curr] = i;
				nQueen(n, curr+1);
			}
		}
	}

}
