package com.xiwai.algorithm.sept.sept4;

public class num53 {
}

class Solution53 {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        int max = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(dp[i], max);

        }
        return max;
    }


//    public int maxSubArray(int[] nums) {
//        int count = 0;
//        int ans = Integer.MIN_VALUE;
//        for (int num : nums) {
//
//            count += num;
//            ans = Math.max(count, ans);
//            if (count < 0) {
//                count = 0;
//
//            }
//        }
//
//        return ans;
//    }
}