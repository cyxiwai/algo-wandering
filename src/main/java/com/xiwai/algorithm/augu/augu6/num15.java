package com.xiwai.algorithm.augu.augu6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class num15 {
    public static void main(String[] args) {
        Solution15 solution = new Solution15();
        int[] nums = {-1, -1, 0, -1, 1, 3, 2, 2, -3, 4};
        System.out.println(solution.threeSum(nums));
    }
}

class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return res;
            }
            //            对A去重复
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;

                } else {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                }
            }
        }
        return res;
    }
}