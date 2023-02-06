package week4;

import java.util.Scanner;

public class Solution_15758 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1 ; tc <= T ; tc++) {
			String s1 = sc.next();
			String s2 = sc.next();
			
			int s1_len = s1.length();
			int s2_len = s2.length();
			
			String t1 = s1;
			String t2 = s2;
			
			if(s1_len != s2_len) {
				int lcm = lcm(s1_len, s2_len);
				while(t1.length() != lcm)
					t1 += s1;
				while(t2.length() != lcm)
					t2 += s2;
			}
			if(t1.equals(t2)) {
				System.out.printf("#%d %s\n",tc, "yes");
			}
			else {
				System.out.printf("#%d %s\n", tc, "no");
			}
			
		}
	}
	
	public static int gcd(int a, int b) {
		if(b == 0)
			return a;
		int mod = 0;
		
		while(b != 0 ) {
			mod = a % b;
			a = b;
			b = mod;
		}
		
		return a;
	}
	
	public static int lcm(int a, int b) {
		return (a * b) / gcd(a,b);
	}

}

