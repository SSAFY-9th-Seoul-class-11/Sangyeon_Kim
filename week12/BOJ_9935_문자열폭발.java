import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_9935_문자열폭발 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] str = br.readLine().toCharArray();
		char[] boom = br.readLine().toCharArray();
		
//		System.out.println(Arrays.toString(str));
//		System.out.println(Arrays.toString(boom));
		
		char[] result = new char[str.length];
		int idx = 0;
		
		
		for(int i = 0 ; i < str.length ; i++) {
			char c = str[i];
			
			if(boom[boom.length - 1] == c) {
				if(idx < boom.length -1 ) {
					result[idx++] = c;
				}else {
					boolean flag = true;
					
					for(int j = idx-1, k = boom.length - 2 ; k >= 0 ; j--, k--) {
						if(result[j] != boom[k]) {
							flag = false;
							break;
						}
					}
					
					if(flag) {
						idx = idx - (boom.length-1);
						result[idx] = ' ';
					}else {
						result[idx++] = c;
					}
				}
			}else {
				result[idx++] = c;
			}
			
			
		}
		
		
		StringBuilder sb = new StringBuilder();
		if(idx == 0) {
			sb.append("FRULA");
		}else {
			for(int i = 0 ; i < idx ; i++) {
				sb.append(result[i]);
			}
		}
		
		System.out.println(sb.toString());
		
		
	}

}
