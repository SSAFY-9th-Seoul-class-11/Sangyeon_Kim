package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_13549 {

	static int n, k, visited[];
	final static int MAX = 100001;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		visited = new int[MAX];
		visited[n] = 1;
		
		
		if(n > k) {// 동생이 수빈이보다 뒤에 있는 경우 
			System.out.println(n - k);
		}else if(n==k) { // 동생의 위치가 수빈이랑 같은 경우
			System.out.println(0);
		}else {
			bfs();			
		}
		
		
	}

	public static void bfs() {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(n);	//현재 위치를 큐에 추가
		int[] cnt = new int[MAX]; //이동 시간을 저장할 배열 cnt를 생성
		
		while(!queue.isEmpty()) {
			int x = queue.poll();
			if(x == k) {
				System.out.println(cnt[x]);
				break;
			}
			for(int i = 0 ; i < 3 ; i++) {
				int nx;
				if(i==0) { //2배 이동할때
					nx = x * 2;
				}else if(i == 1) {	// -1 이동할 때
					nx = x - 1;
				}else {	// +1 이동할 때
					nx = x + 1;
				}
				
				if(nx >= 0 && nx <MAX && visited[nx] == 0) {	// 범위 내에 있고, 방문 안했으면
					queue.add(nx);	// 해당 위치를 큐에 추가
					
					visited[nx] = 1; //방문 표시
					if(i != 0) {	// 2배 이동하는게 아닌 경우
						cnt[nx] = cnt[x] + 1;	// 이동 시간을 +1 해줌
					}else {	// 2배 이동하는 경우에는
						cnt[nx] = cnt[x];	// 이동시간 그대로
					}
				}
			}
		}
	}
}
