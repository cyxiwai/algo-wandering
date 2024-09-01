package com.xiwai.algorithm.augu.augu26;

public class num55 {
    public static void main(String[] args) {
        int[] test = {0};
        Solution55 Solution55 = new Solution55();
        System.out.println(Solution55.canJump(test));
    }
}

class Solution55 {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        if (nums[0] == 0) {
            return false;
        }
        int max_field = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0 && max_field <= i) {
                return false;
            }
            if (nums[i] == 0 && max_field > i) {
                continue;
            }
            max_field = Math.max(max_field, i + nums[i]);
            if (max_field >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}
