package com.xiwai.algorithm.sept.sept3;

public class num309 {
}

class Solution309 {
    public int maxProfit(int[] prices) {
        //四个状态，今天持有股票，今天刚卖股票，今天冷冻期，昨天冷冻期（前天刚卖股票）
        int[][] dp = new int[prices.length][4];
        dp[0][0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][1], dp[i - 1][3]) - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][3]);
            dp[i][2] = dp[i - 1][0] + prices[i];
            dp[i][3] = dp[i - 1][2];
        }
        return Math.max(dp[prices.length - 1][1],
                Math.max(dp[prices.length - 1][2], dp[prices.length - 1][3]));
    }
}
