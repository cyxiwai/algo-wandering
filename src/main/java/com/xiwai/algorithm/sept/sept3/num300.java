package com.xiwai.algorithm.sept.sept3;

public class num300 {
    public static void main(String[] args) {
        int[] test = {10, 9, 2, 5, 3, 7, 101, 18};
        Solution300 s = new Solution300();
        System.out.println(s.lengthOfLIS(test));
    }
}

class Solution300 {
    public int lengthOfLIS(int[] nums) {
        int ans = 0;
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= i - 1; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
