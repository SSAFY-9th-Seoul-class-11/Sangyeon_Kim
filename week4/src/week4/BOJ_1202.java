package week4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_1202 {
	
	static class Jewel{
		int m;	// 보석의 무게 
		int v;	// 보석의 가격
		public Jewel(int m , int v) {
			this.m = m;
			this.v = v;
		}
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		ArrayList<Jewel> list = new ArrayList<>();
		for(int i = 0 ; i < n ; i++) {
			int m = sc.nextInt();
			int v = sc.nextInt();
			list.add(new Jewel(m, v));
		}
		
		Collections.sort(list, (o1, o2) -> o1.m - o2.m);	// 무게 순으로 보석을 정렬 
		
		int[] bags = new int[k];
		for(int i = 0 ; i < k ; i++) {
			bags[i] = sc.nextInt();
		}
		Arrays.sort(bags);
		
		long total = 0;
		int listIdx = 0;
		PriorityQueue<Jewel> pq = new PriorityQueue<>((o1, o2) -> o2.v - o1.v);	// 가격 순으로 보석을 정렬 
		for(int i = 0 ; i < k ; i++) {
			while(listIdx < n && list.get(listIdx).m <= bags[i]) {
				Jewel curr = list.get(listIdx++);
				pq.add(new Jewel(curr.m, curr.v));
			}
			if(!pq.isEmpty()) {
				total += pq.poll().v;
			}
		}
		System.out.println(total);
		
	}

	
}

/*
 1. 보석을 arraylist로 입력받은 후 무게 순서대로 오름차순 정렬한다.
 2. 가방에 담을 수 있는 무게를 입력받은 후 오름차순 정렬한다.
 3. 가격 순서대로 내림차순 정렬을 하는 우선순위 큐를 생성한다.
 4. 현재 가방이 담을 수 있는 최대 무게보다 작거나 같은 무게를 가진 보석을 우선순위 큐에 담아준다.
 5. 우선순위 큐의 제일 첫번째(가장 비싼 보석)을 꺼내 더해준다.
 6. 4~5를 모든 가방이 찰 때까지 반복한다. 
 */
