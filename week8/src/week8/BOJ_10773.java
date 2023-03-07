package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10773 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] stack = new int[N];
		int top = 0;
		
		int cnt = 1;
		
		while(cnt <= N) {
			int tmp = Integer.parseInt(br.readLine());
			if(tmp == 0) {
				top--;
				stack[top] = 0;
				cnt++;
				continue;
			}
			
			stack[top] = tmp;
			top++;
			cnt++;
			
		}
		int sum = 0;
		for(int i  = 0 ; i < N ; i++) {
			sum += stack[i];
		}
		
		System.out.println(sum);
	}

}
