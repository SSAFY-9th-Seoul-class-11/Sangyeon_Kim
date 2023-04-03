package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17281 {

	static int inning, score;
	static int[][] player;
	static int[] lineup;
	static boolean[] picked;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		inning = Integer.parseInt(br.readLine());
		
		// 선수 인덱스 1~9까지 사용
		player = new int[inning][10];
		picked = new boolean[10];
		lineup = new int[10];
		
		for(int i = 0 ; i < inning ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 1 ; j < 10 ; j++) {
				player[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		picked[4] = true;
		lineup[4] = 1;
		
		score = 0;
		
		pickLineup(2);
		
		System.out.println(score);

	}
	
	public static void pickLineup(int num) {
		if(num == 10) {
			playBall();
			return;
		}
		for(int i = 1 ; i <= 9 ; i++) {
			if(picked[i])
				continue;
			
			picked[i] = true;
			lineup[i] = num;
			pickLineup(num + 1);
			picked[i] = false;
		}
	}

	private static void playBall() {
		int tmp_score = 0;
		int currHitter = 1;	// 현재 타자
		boolean[] base;
		
		for(int i = 0 ; i < inning ; i++) {
			int out = 0;
			base = new boolean[4];
			
			Loop: while(true) {
				for(int j = currHitter ; j <= 9 ; j++) {
					int hitter = player[i][lineup[j]];
					switch (hitter) {
					case 0:	//아웃
						out++;
						break;
					case 1: // 1루타
						for(int k = 3 ; k >= 1 ; k--) {
							if(base[k]) {
								if(k == 3) {
									tmp_score++;
									base[k] = false;
									continue;
								}
								base[k] = false;
								base[k+1] = true;
							}
						}
						base[1] = true;
						break;
					case 2:	// 2루타
						for(int k = 3 ; k >= 1 ; k--) {
							if(base[k]) {
								if(k == 3 || k == 2) {
									tmp_score++;
									base[k] = false;
									continue;
								}
								base[k] = false;
								base[k+2] = true;
							}
						}
						base[2] = true;
						break;
					case 3:	// 3루타
						for(int k = 3 ; k >= 1 ; k--) {
							if(base[k]) {
								tmp_score++;
								base[k] = false;
								continue;
							}
						}
						base[3] = true;
						break;
						
					case 4:
						for(int k = 3 ; k >= 1 ; k--) {
							if(base[k]) {
								tmp_score++;
								base[k] = false;
								continue;
							}
						}
						tmp_score++;
						break;
					}
					if(out == 3) {
						currHitter = j + 1;
						if(currHitter == 10) {
							currHitter = 1;
						}
						break Loop;
					}
				}
				currHitter = 1;
				
			}
			
		}
	
		score = Math.max(tmp_score, score);
	
	}

}
