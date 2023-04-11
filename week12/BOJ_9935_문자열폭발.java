import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_9935_문자열폭발 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] str = br.readLine().toCharArray();	// 처음 입력 받는 문자열
		char[] boom = br.readLine().toCharArray();	// 터지는 문자열 
		
//		System.out.println(Arrays.toString(str));
//		System.out.println(Arrays.toString(boom));
		
		char[] result = new char[str.length];
		int idx = 0;
		
		
		for(int i = 0 ; i < str.length ; i++) {
			char c = str[i];	// 문자열을 맨 앞부터 꺼내서 탐색
			
			if(boom[boom.length - 1] == c) {	// 만약 c가 터지는 문자열의 맨 뒤와 같으면 
				if(idx < boom.length -1 ) {	//idx가 터지는 문자열의 맨 뒤 인덱스보다 작으면 해당 c를 result에 저장하고 idx를 1 증가
					result[idx++] = c;
				}else {	// 아니면
					boolean flag = true;	// flag는 트루
					
					for(int j = idx-1, k = boom.length - 2 ; k >= 0 ; j--, k--) {
						if(result[j] != boom[k]) {
							flag = false;
							break;
						}
					}
					
					if(flag) {	// 플래그가 트루면	>> 폭탄 끝 글자 앞의 글자들을 result 배열에서 뺴줌
						idx = idx - (boom.length-1);	// 폭탄 길이만큼 idx를 빼줌
						result[idx] = ' ';//해당 idx에 공백을 출력
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
