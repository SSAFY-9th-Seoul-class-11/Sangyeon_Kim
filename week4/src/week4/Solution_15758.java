package week4;

import java.util.Scanner;	

// 15758. 무한 문자열 
public class Solution_15758 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1 ; tc <= T ; tc++) {
			String s1 = sc.next();	// 처음 문자열 두개를 s1, s2에 입력받음 
			String s2 = sc.next();
			
			int s1_len = s1.length();	// 처음 입력받은 s1과 s2의 길이를 저장함 
			int s2_len = s2.length();
			
			String t1 = s1;	// 두 문자열의 길이를 맞춰주기 위해 t1, t2에 각각 s1, s2를 대입 
			String t2 = s2;
			
			if(s1_len != s2_len) {	//입력받은 두 문자열의 길이가 다르면 
				int lcm = lcm(s1_len, s2_len);	// 두 길이의 최소 공배수를 구함 
				while(t1.length() != lcm)	// t1의 길이가 최소공배수가 아니면 s1에서 글자를 하나씩 추가
					t1 += s1;
				while(t2.length() != lcm)
					t2 += s2;
			}
			if(t1.equals(t2)) {	//equals로 두 문자열을 비교해서 같으면 yes, 다르면 no 출력 
				System.out.printf("#%d %s\n",tc, "yes");
			}
			else {
				System.out.printf("#%d %s\n", tc, "no");
			}
			
		}
	}
	
//최소공배수를 구하기 위한 최대공약수 메소드 
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

