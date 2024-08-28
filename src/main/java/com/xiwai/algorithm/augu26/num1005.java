package com.xiwai.algorithm.augu26;

import java.lang.reflect.Array;
import java.util.Arrays;

public class num1005 {
    public static void main(String[] args) {
        Solution1005 Solution1005 = new Solution1005();
        int[] test = {-2, 5, 0, 2, -2};
        System.out.println(Solution1005.largestSumAfterKNegations(test, 3));
    }
}

class Solution1005 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length && k > 0; i++) { // 贪心点, 通过负转正, 消耗尽可能多的k
            if (nums[i] < 0) {
                nums[i] = -nums[i];
                k--;
            }
        }
        if (k % 2 == 1) {
            Arrays.sort(nums);
            nums[0] *= (-1);
        }
        int res = 0;
        for (int num : nums) {
            res += num;
        }
        return res;
    }
}
