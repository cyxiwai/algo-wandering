package com.xiwai.algorithm.sept.sept2;

public class num213 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] test = {1, 2, 3, 1};
        System.out.println(s.rob(test));
    }
}

class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int head_exc = robf(nums, 1, nums.length);
        int tail_exc = robf(nums, 0, nums.length - 1);
        return Math.max(head_exc, tail_exc);
    }

    public int robf(int[] nums, int m, int n) {
        int pre = 0, cur = 0, next = 0;
        for (int i = m; i < n; i++) {
            cur = next;
            next = Math.max(cur, pre + nums[i]);
            pre = cur;//模拟dp数组的滚动降低空间复杂度。
        }
        return next;
    }
}