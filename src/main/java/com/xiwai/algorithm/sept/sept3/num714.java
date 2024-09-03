package com.xiwai.algorithm.sept.sept3;

public class num714 {
}

class Solution714 {
    public int maxProfit(int[] prices, int fee) {
        int[] dp = new int[2];
        dp[0] = -prices[0];
        for (int i = 0; i < prices.length; i++) {
            dp[0] = Math.max(dp[0], dp[1] - prices[i]);
            dp[1] = Math.max(dp[1], dp[0] + prices[i] - fee);
        }
        return Math.max(dp[0], dp[1]);
    }
}
