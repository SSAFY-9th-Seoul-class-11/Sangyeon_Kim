package week2;

import java.util.Scanner;

public class BOJ_1946 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1 ; tc <= T ; tc++ ) {
			int N = sc.nextInt();
			int[] arr = new int[N+1];
			int result = 1;
			
			for(int i = 0 ; i < N ; i++) {
				int paper = sc.nextInt();
				int interview = sc.nextInt();
				arr[paper] = interview;
			}
			
			int standard = arr[1];
			for(int i = 2; i<=N ; i++) {
				if(standard > arr[i]) {
					result++;
					standard = arr[i];
				}
			}
			
			
			System.out.println(result);
		}
		
		sc.close();
	}

}
