package com.xiwai.algorithm.augu22;

import java.util.ArrayList;
import java.util.List;

public class num78 {
}

class Solution78 {
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {

        ans.add(new ArrayList<>());
        backTracing(nums, 0);
        return ans;
    }

    public void backTracing(int[] nums, int startIndex) {
        if (ans.size() == Math.pow(2, nums.length)) {
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            ans.add(new ArrayList<>(path));
            backTracing(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
