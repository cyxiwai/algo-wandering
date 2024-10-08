package com.xiwai.algorithm.sept.sept2;

import java.util.Scanner;

public class kama57 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (i >= j) {
                    dp[i] += dp[i - j];
                }
            }
        }
        System.out.println(dp[n]);

    }
}
