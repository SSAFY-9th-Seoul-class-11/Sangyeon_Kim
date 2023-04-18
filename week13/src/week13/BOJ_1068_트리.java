package week13;

import java.util.Scanner;

public class BOJ_1068_트리 {

	static int N, root, parent[], delete, result;
	static boolean[] isVisited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		parent = new int[N];
		for(int i = 0 ; i < N ; i++) {
			parent[i] = sc.nextInt();
			if(parent[i] == -1)
				root = i;
		}
		delete = sc.nextInt();
		
		removeNode(delete);
	
		result = 0;
		isVisited = new boolean[N];
		leafCnt(root);
		
		System.out.println(result);
		
	
	}
	
	public static void leafCnt(int idx) {
		 boolean isLeaf = true;
	        isVisited[idx] = true;
	        if(parent[idx] != -2){
	            for(int i = 0 ; i < N ; i++){
	                if(parent[i] == idx && !isVisited[i]){
	                    leafCnt(i);
	                    isLeaf = false;
	                }
	            }
	            if(isLeaf)
	                result++;
	        }
		
	}
	public static void removeNode(int d) {
		parent[d] = -2;
		
		for(int i = 0 ; i < N ; i++) {
			if(parent[i] == d) {
				removeNode(i);
			}
		}
	}

}
