package com.xiwai.algorithm.augu22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class num90 {
}

class Solution {
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {


        ans.add(new ArrayList<>());
        Arrays.sort(nums);
        backTracing(nums, 0);
        return ans;
    }

    public void backTracing(int[] nums, int startIndex) {
        ans.add(new ArrayList<>(path));
        if (ans.size() == Math.pow(2, nums.length)) {
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            if (i > startIndex && nums[i] == nums[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            backTracing(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }


}
