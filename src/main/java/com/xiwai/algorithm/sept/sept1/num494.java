package com.xiwai.algorithm.sept.sept1;

public class num494 {
    public static void main(String[] args) {
        int[] test = {0, 0, 0, 0, 0, 0, 0, 0, 0, 1};

        Solution494 so = new Solution494();
        System.out.println(so.findTargetSumWays(test, 1));
    }
}

class Solution494 {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int act_target = (sum + target) / 2;
        if ((sum + target) % 2 == 1 || Math.abs(target) > sum) {
            return 0;
        }
        int[] dp = new int[act_target + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = act_target; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[act_target];
//        int[][] dp = new int[nums.length][act_target + 1];
//        for (int i = 0; i < nums.length; i++) {
//            dp[i][0] = 1;
//        }
//        if (nums[0] <= act_target) dp[0][nums[0]] += 1;
//        for (int i = 1; i < nums.length; i++) {
//            for (int j = 0; j <= act_target; j++) {
//                if (j >= nums[i]) {
//                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i]];
//                } else
//                    dp[i][j] = dp[i - 1][j];
//            }
//        }
//        return dp[nums.length - 1][act_target];
    }
}