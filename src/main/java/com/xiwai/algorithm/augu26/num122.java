package com.xiwai.algorithm.augu26;

public class num122 {
}

class Solution122 {
    public int maxProfit(int[] prices) {
        int[] day_pro = new int[prices.length - 1];
        for (int i = 1; i < prices.length; i++) {
            day_pro[i - 1] = prices[i] - prices[i - 1];
        }
        int ans = 0;
        for (int i = 0; i < day_pro.length; i++) {
            ans += Math.max(day_pro[i], 0);
        }
        return ans;
    }
}