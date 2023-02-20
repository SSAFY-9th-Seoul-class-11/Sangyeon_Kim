package week6;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution_5248 {
	
	static int[] arr;
	static int n, m, result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1 ; tc <= T ; tc++) {
			n = sc.nextInt();
			m = sc.nextInt();
			
			arr = new int[n+1];
			
			for(int i = 1 ; i <= n ; i++) {
				arr[i] = i;	// 처음에는 자기 혼자 조 구성 
			}
			
			for(int i = 0 ; i < m ; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				union(a, b);	// 조 만들기 시작 - 연결되어 있는 노드들을 한 조로 묶어줌 
			}
			
			Set<Integer> team = new HashSet<Integer>();
			for(int i = 1 ; i <= n ; i++) {	// 모든 노드들을 돌면서 각 노드가 속해있는 조의 부모 개수를 구하면 몇개의 조가 있는지 확인 가능 
				team.add(getParent(i));
			}
			
			System.out.printf("#%d %d\n", tc, team.size());
		}

	}
	
	private static void union(int a, int b) {	// 두 노드를 합치는 메소드 
		int x = getParent(a);
		int y = getParent(b);
		if(x > y)
			arr[x] = y;
		else
			arr[y] = x;
	}
	
	private static int getParent(int x) {	// 해당 노드가 속해있는 부모를 찾는 메소드 
		if(arr[x] != x)
			arr[x] = getParent(arr[x]);
		return arr[x];
	}

}
