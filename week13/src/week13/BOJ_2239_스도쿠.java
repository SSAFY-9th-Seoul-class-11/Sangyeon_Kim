package week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_2239_스도쿠 {
	
	static int[][] board = new int[9][9];
	static ArrayList<int[]> list = new ArrayList<int[]>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		for(int i = 0 ; i < 9 ; i++) {
			String input = br.readLine();
			for(int j = 0 ; j < 9 ; j++) {
				board[i][j] = input.charAt(j) - '0';
				
				if(board[i][j] == 0)	// 빈칸(0)인 칸의 좌표를 list에 저장 
					list.add(new int[] {i, j});
			}
			
		}
		
		sudoku(0);
		
	}
	
	public static void sudoku(int depth) {
		if(list.size() == depth) {	// depth가 빈칸 크기와 같아지면 스도쿠 판을 출력하고 종료 
			print();
			System.exit(0);
		}
		
		boolean[] used = new boolean[10]; // 1부터 10까지 겹치는게 있는지 확인할겨 이미 사용된 숫자는 true
		
		int x = list.get(depth)[0];
		int y = list.get(depth)[1];
		
		for(int i = 0 ; i < 9 ; i++) {	// 가로 확인 
			if(board[x][i] != 0)
				used[board[x][i]] = true;
		}
		for(int i = 0 ; i < 9 ; i++) {	// 세로 확인 
			if(board[i][y] != 0)
				used[board[i][y]] = true;
		}
		
		// 박스 범위 설정 
		int boxX = (x/3) * 3;
		int boxY = (y/3) * 3;
		
		for(int i = boxX ; i < boxX + 3 ; i++) {	// 박스 단위 확인 
			for(int j = boxY ; j < boxY + 3 ; j++) {
				if(board[i][j] != 0)
					used[board[i][j]] = true;
			}
		}
		
		for(int i = 1 ; i < 10; i++) {
			if(!used[i]) {	// 안쓰인 숫자를 board에 넣고 dfs를 돌림. 다시 0으로 넣고 다음 안쓰인 숫자를 넣고 빙빙 돌려 
				board[x][y] = i;
				sudoku(depth+1);
				board[x][y] = 0;
			}
		}
		
		
		
	}

	public static void print() {
		for(int i = 0 ; i < 9 ; i++) {
			for(int j = 0 ; j < 9 ; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}
}
