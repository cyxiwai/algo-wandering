package com.xiwai.algorithm.sept.sept26;

import java.util.Arrays;

public class num41 {
    public static void main(String[] args) {
        Solution41 s = new Solution41();
        int[] tes = {1, 2, 0};
        System.out.println(s.firstMissingPositive(tes));
    }
}

class Solution41 {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int minV = Integer.MAX_VALUE;
        int maxV = nums[nums.length - 1];
        int minV_index = -1;
        if (maxV <= 0) {
            return 1;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0 && nums[i] < minV) {
                minV = nums[i];
                minV_index = i;
            }
        }
        if (minV > 1) {
            return 1;
        }
        int ans = 1;
        for (int i = minV_index; i < nums.length - 1; i++) {
            if (nums[i + 1] != minV + 1) {
                ans = minV + 1;
            } else {
                minV++;
            }
        }
        return minV == nums[nums.length - 1] ? minV + 1 : ans;
    }
}
