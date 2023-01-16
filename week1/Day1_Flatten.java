package week1;

import java.util.Scanner;
import java.util.Arrays;

public class Day1_Flatten {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		
		for(int tc = 1; tc <= T ; tc++ ) {
			int N = sc.nextInt();
			int[] arr = new int[100];
			int max_h = 1;
			int max_idx = 0;
			int min_h = 100;
			int min_idx = 0;
			
			for(int i = 0; i<100 ; i++) {
				arr[i] = sc.nextInt();
			}
			
			for(int dump = 0; dump < N ; dump++) {
				max_h = 1;
				max_idx = 0;
				min_h = 100;
				min_idx = 0;
				
				//최대 최저 높이 & 인덱스 확인
				for(int i = 0 ; i < 100 ; i++) {
					if(max_h < arr[i]) {
						max_h = arr[i];
						max_idx = i;
					}
					if(min_h > arr[i]) {
						min_h = arr[i];
						min_idx = i;
					}
				}
				arr[max_idx] -= 1;
				arr[min_idx] += 1;
			}
			Arrays.sort(arr);
			
			System.out.printf("#%d %d\n",tc, arr[arr.length - 1] - arr[0]);
		}

	}

}
