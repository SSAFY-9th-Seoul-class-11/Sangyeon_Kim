package week2;

import java.util.Scanner;

public class BOJ_2839 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int bags = 0;
		
		while(true) {
			
			if(n%5 == 0) {
				bags += n/5;
				System.out.println(bags);
				break;
			}else {
				n -= 3;
				bags++;
			}
			if(n < 0) {
				System.out.println("-1");
				break;
			}
			
		}
	}

}
