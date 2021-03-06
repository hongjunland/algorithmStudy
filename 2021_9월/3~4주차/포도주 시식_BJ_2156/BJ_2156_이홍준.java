package com.company;

import java.util.Scanner;

public class BJ_2156_이홍준 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N+1];
        int[] dp = new int[N+1];
        for (int i = 1; i <= N; i++) {
            nums[i] = sc.nextInt();
        }
        dp[1] = nums[1];
        if(N>1) dp[2] = nums[1]+nums[2];
        for (int i = 3; i <= N; i++) dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + nums[i], dp[i - 3] + nums[i - 1] + nums[i]));
        System.out.println(dp[N]);
    }
}
