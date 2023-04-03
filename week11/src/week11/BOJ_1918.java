package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_1918 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String st = br.readLine();
		
		Stack<Character> stack = new Stack<>();
		
		for(int i = 0 ; i < st.length() ; i++) {
			char curr = st.charAt(i);
			
			switch(curr) {
			case '+':
			case '-':
			case '*':
			case '/':
				while(!stack.isEmpty() && priority(stack.peek()) >= priority(curr)) {
					sb.append(stack.pop());
				}
				stack.add(curr);
				break;
				
			case '(':
				stack.add(curr);
				break;
			case ')':
				while(!stack.isEmpty() && stack.peek() != '(') {
					sb.append(stack.pop());
				}
				stack.pop();
				break;
			default:
				sb.append(curr);
			}
		}
		
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		System.out.println(sb.toString());

	}
	
	public static int priority(char op) {
		if(op == '(' || op == ')') {
			return 0;
		}else if(op == '+' || op == '-') {
			return 1;
		}else if(op == '*' || op == '/') {
			return 2;
		}
		return -1;
	}

}
