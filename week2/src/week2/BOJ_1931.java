package week2;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1931 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] table = new int[N][2];
		
		for(int i = 0 ; i < N ; i++) {
			table[i][0] = sc.nextInt();	//시작시간 
			table[i][1] = sc.nextInt(); //종료시간 
		}
		
		Arrays.sort(table, (o1, o2) -> {
			if(o1[1] == o2[1]) {
				return o1[0] - o2[0];
			}
			return o1[1] - o2[1];
		});
		
		int cnt = 0;
		int end = 0;
		
		for(int i = 0 ; i < N ; i++) {
			if(end <= table[i][0]) {
				end = table[i][1];
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}

}
