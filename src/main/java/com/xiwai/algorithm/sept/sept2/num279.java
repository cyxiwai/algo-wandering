package com.xiwai.algorithm.sept.sept2;

public class num279 {
}

class Solution279 {
    public int numSquares(int n) {
        int[] Square = getSquared(100);
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < Square.length; i++) {
            for (int j = Square[i]; j <= n; j++) {
                dp[j] = Math.min(dp[j - Square[i]] + 1, dp[j]);
            }
        }
        return dp[n];
    }

    public int[] getSquared(int n) {
        int[] Square = new int[n];
        for (int i = 1; i <= n; i++) {
            Square[i - 1] = i * i;
        }
        return Square;
    }
}
