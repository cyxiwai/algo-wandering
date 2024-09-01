package com.xiwai.algorithm.augu.augu25;

public class num121 {
}

class Solution121 {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            ans = Math.max(prices[i] - min, ans);
        }
        return ans;

    }
}
