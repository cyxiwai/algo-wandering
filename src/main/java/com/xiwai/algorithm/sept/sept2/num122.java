package com.xiwai.algorithm.sept.sept2;

public class num122 {
}

class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }
        return Math.max(dp[prices.length - 1][1], dp[prices.length - 1][0]);

//        int[] day_pro = new int[prices.length - 1];
//        for (int i = 1; i < prices.length; i++) {
//            day_pro[i - 1] = prices[i] - prices[i - 1];
//        }
//        int ans = 0;
//        for (int i = 0; i < day_pro.length; i++) {
//            ans += Math.max(day_pro[i], 0);
//        }
//        return ans;
    }
}
