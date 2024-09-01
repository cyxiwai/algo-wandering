package com.xiwai.algorithm.augu.augu26;

public class num45 {
}

class Solution45 {
    public int jump(int[] nums) {
        int count = 0;
        if (nums.length == 1) {
            return count;
        }
        int max_filed = 0;
        int cur_filed = 0;
        for (int i = 0; i < nums.length; i++) {
            max_filed = Math.max(max_filed, i + nums[i]);
            if (max_filed >= nums.length - 1) {
                count++;
                break;
            }
            if (i == cur_filed) {
                cur_filed = max_filed;
                count++;
            }
        }
        return count;
    }
}
