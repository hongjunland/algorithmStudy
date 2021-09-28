package bj.week5;

import java.util.Scanner;

public class BJ_1010_이홍준 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t <T ; t++) {
            int R = sc.nextInt();
            int N = sc.nextInt();
            int[][] dp = new int[N+1][R+1];
            for(int i = 0 ; i <= N ; i++){
                for(int j = 0 ; j <= R ; j++){
                    if(j==0 || i==j || i==0) dp[i][j] = 1;
                    else dp[i][j] = dp[i-1][j]+ dp[i-1][j-1];
                }
            }
            System.out.println(dp[N][R]);
        }
    }
}
