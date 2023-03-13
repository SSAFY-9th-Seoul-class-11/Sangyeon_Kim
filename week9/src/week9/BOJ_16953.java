package week9;

import java.util.Scanner;

public class BOJ_16953 {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		int result = 0;
		
		while(B != A) {
			if(B < A) {
				result = -1;
				break;
			}
			
			if(B % 2 == 0) {
				B = B/2;
			}
			else if(B % 10 == 1) {
				B = B / 10;
			}
			else {
				result = -1;
				break;
			}
			result++;
		}
		
		System.out.println(result > -1 ? result + 1 : result);
		
	}

}
