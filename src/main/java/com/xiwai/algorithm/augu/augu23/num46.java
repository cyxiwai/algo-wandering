package com.xiwai.algorithm.augu.augu23;

import java.util.ArrayList;
import java.util.List;

public class num46 {
}

class Solution46 {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            used[i] = false;
        }
        backTracing(nums, used);
        return ans;
    }

    public void backTracing(int[] nums, boolean[] used) {

        if (path.size() == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
//        如要求所有的字集及其全排列，加这段
//        if (!path.isEmpty()) {
//            ans.add(new ArrayList<>(path));
//        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
            backTracing(nums, used);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}