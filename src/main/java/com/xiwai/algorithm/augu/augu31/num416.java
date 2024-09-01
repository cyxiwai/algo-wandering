package com.xiwai.algorithm.augu.augu31;

public class num416 {
}

class Solution146 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }

        int[] dp = new int[10001];
        for (int num : nums) {
            for (int j = sum / 2; j >= num; j--) {
                dp[j] = Math.max(dp[j], dp[j - num] + num);

            }
        }
        if (dp[sum / 2] == sum / 2) {
            return true;
        }
        return false;
    }
}