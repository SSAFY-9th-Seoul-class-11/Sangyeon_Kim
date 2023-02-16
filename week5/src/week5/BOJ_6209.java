package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
//import java.util.Scanner;

public class BOJ_6209 {

	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		
		int d = Integer.parseInt(temp[0]);	// 돌섬~탈출구까지 거리 
		int n = Integer.parseInt(temp[1]);	// 돌섬의 수  
		int m = Integer.parseInt(temp[2]);	// 제거할 수 있는 돌섬 수 
		int[] arr = new int[n+1];
		
		arr[n] = d;
		for(int i = 0 ; i < n ; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);	// 돌 섬 개수를 정렬하고, 마지막에 목적지 추가 
		
		int left = 0;
		int right = d;
		int result = 0;
		
		while(left <= right) {
			int mid = left + right / 2;
			int curr = 0;	// 현재 탐색 위
			int cnt = 0;	// 제거한 바위 개수
//			int min_distance = d;
			
			for(int i = 0 ; i < n ; i++) {
				if(arr[i] - curr < mid) {
					cnt += 1;
				}else {
//					min_distance = Math.min(min_distance, arr[i] - curr);
					curr = arr[i];
				}
			}
			
			if(cnt <= m) {
				left = mid + 1;
			}else
				right = mid - 1;
			result = right;
			
		}
		
		System.out.println(result);
	}

}
