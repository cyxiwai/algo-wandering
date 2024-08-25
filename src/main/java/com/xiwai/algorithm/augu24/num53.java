package com.xiwai.algorithm.augu24;

public class num53 {

}

class Solution53 {
    public int maxSubArray(int[] nums) {
        int count = 0;
        int ans = Integer.MIN_VALUE;
        for (int num : nums) {

            count += num;
            ans = Math.max(count, ans);
            if (count < 0) {
                count = 0;

            }
        }

        return ans;
    }
}