package com.xiwai.algorithm.augu.augu22;

import java.util.ArrayList;
import java.util.List;

public class num491 {
}

class Solution {
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    int count = 0;

    public List<List<Integer>> findSubsequences(int[] nums) {
        backTracing(nums, 0, Integer.MIN_VALUE);
        return ans;
    }

    public void backTracing(int[] nums, int startIndex, int pre) {
        if (startIndex == nums.length) {
            if (!path.isEmpty()) {
                ans.add(new ArrayList<>(path));
            }
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            if (i > startIndex && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] >= pre) {
                path.add(nums[i]);
                backTracing(nums, i + 1, nums[i]);
                path.remove(path.size() - 1);
            }
        }

    }
}