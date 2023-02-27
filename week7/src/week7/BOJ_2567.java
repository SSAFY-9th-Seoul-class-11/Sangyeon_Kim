package week7;

import java.util.Scanner;

public class BOJ_2567 {
	static int[][] map = new int[100][100];
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int result;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();	// 색종이의 개수
		for(int i = 0 ; i < N ; i++) {
			int r = sc.nextInt();	//왼쪽 차
			int c = sc.nextInt();	// 아래 차
			
			// 색종이가 붙여진 부분 1로 채우기
			for(int j = r ; j < r+10 ; j++	) {
				for(int k = c ; k < c + 10 ; k++) {
					map[j][k] = 1;
				}
			}
		}
		
		//둘레 카운팅
		for(int i = 0 ; i < 100 ; i++) {
			for(int j = 0 ; j < 100 ; j++) {
				cnt_round(i,j);
			}
		}
		
		System.out.println(result);

	}

	private static void cnt_round(int x, int y) {
		//해당 칸이 0이면 필요 없음
		if(map[x][y] == 0)
			return;
		
		for(int i = 0 ; i < 4 ; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			//현재 위치가 1이고, 자기 옆이 0이면 둘레 카운팅
			if(0 <= nx && nx < 100 && ny >= 0 && ny < 100 && map[nx][ny] == 0 ) {
				result++;
			}
			
			//윗면에 밀착한 경우
			if(0 > nx)
				result++;
			
			//아랫면에 밀착한 경우
			if(0 > ny)
				result++;
			
			//오른쪽 면에 밀착한 경우
			if(100 <= nx)
				result++;
			
			//왼쪽 면에 밀착한 경우
			if(100 <= ny)
				result++;
		}
	}
	
}
