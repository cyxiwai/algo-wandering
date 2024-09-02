package com.xiwai.algorithm.sept.sept2;

public class num121 {
}

class Solution121 {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];//二维代表是否持有，本身代表剩余资金多少，一维控制天数，
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], prices[i] + dp[i - 1][0]);
        }
        return Math.max(dp[prices.length - 1][0], dp[prices.length - 1][1]);
    }
}
//
//class Solution {
//    public int maxProfit(int[] prices) {
//        int ans = 0;
//        int min = prices[0];
//        for (int i = 1; i < prices.length; i++) {
//            if (prices[i] < min) {
//                min = prices[i];
//            }
//            ans = Math.max(prices[i] - min, ans);
//        }
//        return ans;
//
//    }
//}
