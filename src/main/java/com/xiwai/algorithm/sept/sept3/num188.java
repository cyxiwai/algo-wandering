package com.xiwai.algorithm.sept.sept3;

public class num188 {
}

class Solution188 {
    public int maxProfit(int k, int[] prices) {
        int[] dp = new int[2 * k + 1];
        for (int i = 1; i <= 2 * k; i++) {
            if (i % 2 == 1) {
                dp[i] = -prices[0];
            }
        }
        for (int price : prices) {
            for (int j = 1; j <= 2 * k; j++) {
                if (j % 2 == 1) {
                    dp[j] = Math.max(dp[j], dp[j - 1] - price);
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1] + price);
                }
            }
        }
        return dp[2*k];
    }
}