package week3;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_1860 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N, M, K;	//N: 손님 수, M: 붕어빵 만드는데 걸리는 시간, K: 한번에 만들어지는 붕어빵 수 
		int T = sc.nextInt();
		int[] customers;
		
		for(int tc = 1 ; tc <= T ; tc++) {
			String result = "Possible";
			N = sc.nextInt();
			M = sc.nextInt();
			K = sc.nextInt();
			
			customers = new int[N];
			//손님이 오는데 걸리는 시간을 정렬 
			for(int i = 0 ; i < N ; i++) {
				customers[i] = sc.nextInt();
			}
			Arrays.sort(customers);
			
			for(int i = 1 ; i <= N ; i++) {
				int time = customers[i-1];
				int done = time / M * K - i;
				if(done < 0) {
					result = "Impossible";
					break;
				}
			}
		
			System.out.printf("#%d %s\n", tc, result);
		}
		
	}

}
