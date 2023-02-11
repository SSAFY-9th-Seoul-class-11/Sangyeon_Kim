package week5;

import java.util.Scanner;

public class Solution_9940 {
 
 
     
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        int T = sc.nextInt();
         
        for(int tc = 1 ; tc <= T ; tc++) {
             
            int N = sc.nextInt();
            int[] arr = new int[N+1];
            boolean[] isSelected = new boolean[N+1];
            boolean isPermu = true;
             
            for(int i = 1 ; i <= N ; i++ ) {
                arr[i] = sc.nextInt();
                if(isSelected[arr[i]]) {
                    isPermu = false;
                    //break;
                }
                isSelected[arr[i]] = true;
            }
             
            if(isPermu) {
                System.out.printf("#%d %s\n", tc, "Yes");
            } else {
                System.out.printf("#%d %s\n", tc, "No");                
            }
             
             
             
             
        }
        sc.close();
 
    }
     
     
 
}