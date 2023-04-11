import java.util.Scanner;

public class BOJ_1929_소수구하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int M = sc.nextInt();
		int N = sc.nextInt();

		int[] arr= new int[N+1];
		
		// 1) 배열 초기화
		for(int i = 2 ; i <= N; i++) {
			arr[i] = i;	
		}
		
		// 2) 2부터 시작해서 특정 수의 배수를 모두 지운다
		for(int i = 2 ; i <= N ; i++) {
			if(arr[i] == 0)
				continue;
			
			for(int j = 2 * i ; j <= N ; j+=i) {
				arr[j] = 0;
			}
		}
		
		// 3) M부터 결과 출력
		for(int i = M ; i <= N ; i++) {
			if(arr[i] != 0)
				System.out.println(arr[i]);
		}
		
		
	}

}