package com.xiwai.algorithm.augu6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class num18 {
    public static void main(String[] args) {
        Solution18 solution = new Solution18();
        int[] nums = {-3, -2, -1, 0, 0, 1, 2, 3};
        System.out.println(solution.fourSum(nums, 0));
    }
}

class Solution18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > target && (nums[i] >= 0 || target >= 0)) {
                return res;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > (target - nums[i]) && (nums[j] >= 0 || (target - nums[i]) >= 0)) {
                    break;
                }
                if (j > (i + 1) && nums[j] == nums[j - 1]) {
                    continue;
                }
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    long sum = (long) nums[j] + nums[left] + nums[right];
                    if (sum > target - nums[i]) {
                        right--;
                    } else if (sum < target - nums[i]) {
                        left++;
                    } else {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        right--;
                        left++;
                    }
                }
            }
        }
        return res;
    }
}