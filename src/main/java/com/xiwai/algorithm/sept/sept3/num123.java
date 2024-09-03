package com.xiwai.algorithm.sept.sept3;

public class num123 {
    public static void main(String[] args) {
        int[] test = {3, 3, 5, 0, 0, 3, 1, 4};
        Solution123 s = new Solution123();
        System.out.println(s.maxProfit(test));
    }
}

class Solution123 {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][5];
        //五个状态，什么事都没做，第一次持有，第一次不持有，第二次持有和第二次不持有
        //第一次持有意味着要么是今天买的，要么是昨天就有的，那就是两种情况，又要取最大值，所以是max两者
        //第一次不持有意味着要么是今天卖的，要么就是昨天就没有，同理，dp[i][2]=dp[i-1][1]+price[i],dp[i-1][2]
        //第二次持有意味着有零钱结余，要么是之前就已经第二次持有了，要么就是第一次不持有然后买了
        //dp[i][3]=dp[i-1][3],dp[i-1][2]-price[i]
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;
        dp[0][3] = -prices[0];
        dp[0][4] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = dp[i - 1][0];
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
            dp[i][2] = Math.max(dp[i - 1][1] + prices[i], dp[i - 1][2]);
            dp[i][3] = Math.max(dp[i - 1][2] - prices[i], dp[i - 1][3]);
            dp[i][4] = Math.max(dp[i - 1][3] + prices[i], dp[i - 1][4]);
        }
        return Math.max(dp[prices.length - 1][0], Math.max(dp[prices.length - 1][1]
                , Math.max(dp[prices.length - 1][2], Math.max(dp[prices.length - 1][3],
                        dp[prices.length - 1][4]))));

    }
}
