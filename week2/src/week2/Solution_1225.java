package week2;

//암호생성기

import java.util.Scanner;

public class Solution_1225 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = 10;
		
		for(int tc = 1 ; tc <= T ; tc++ ) {
			
			int tno = sc.nextInt();
			int[] pw = new int[8];
			int cnt = 1;
			int idx = 0;
			
			
			
			for(int i = 0 ; i < 8 ; i++ ) {	//최초 숫자 8개 입력 
				pw[i] = sc.nextInt();
			}
			
			Loop: while(true) {
		
				for(int i = 0 ; i < pw.length ; i++ ) {
					pw[i] -= cnt++;
					if(cnt > 5) {
						cnt = 1;
					}
					if(pw[i] <= 0 ) {
						pw[i] = 0;
						idx = i;
						break Loop;
					}
				}
				
				
			}
			
			System.out.printf("#%d ",tno);
			for(int i = idx + 1 ; i < pw.length ; i++) {
				System.out.printf("%d ", pw[i]);
			}
			for(int i = 0 ; i <= idx ; i++) {
				System.out.printf("%d ",pw[i] );
			}
			
		}
	}

}
