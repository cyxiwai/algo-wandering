package com.xiwai.algorithm.sept.sept3;

import java.util.Arrays;

public class num674 {
    public static void main(String[] args) {
        int[] test = {1, 2, 3, 5, 4, 6};
        Solution674 s = new Solution674();
        System.out.println(s.findLengthOfLCIS(test));
    }
}

class Solution674 {
    public int findLengthOfLCIS(int[] nums) {
        int[] dp = new int[nums.length];
        int ans = 1;
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            }
            ans = Math.max(dp[i], ans);
        }
        return ans;

    }
}

//
//class Solution674 {
//    public int findLengthOfLCIS(int[] nums) {
//        int ans = 1;
//        int temp = 1;
//        for (int i = 1; i < nums.length; i++) {
//            if (nums[i] > nums[i - 1]) {
//                temp++;
//            } else {
//                ans = Math.max(ans, temp);
//                temp = 1;
//            }
//        }
//        ans = Math.max(ans, temp);
//        return ans;
//    }
//}