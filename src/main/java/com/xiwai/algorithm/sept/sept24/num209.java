package com.xiwai.algorithm.sept.sept24;

import java.util.Arrays;

public class num209 {
}

class Solution209 {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int left = 0;
        int ans = n + 1;
        int sum = 0;
        for (int right = 0; right < n; right++) {
            sum += nums[right];
            while (sum - nums[left] >= target) {
                sum -= nums[left++];
            }
            if (sum >= target) {
                ans = Math.min(ans, right - left + 1);
            }
        }
        return ans <= n ? ans : 0;
    }
}