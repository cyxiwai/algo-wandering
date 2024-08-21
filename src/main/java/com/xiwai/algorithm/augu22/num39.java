package com.xiwai.algorithm.augu22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class num39 {
    public static void main(String[] args) {
//        Solution solution = new Solution();
//        int[] testnum = {1, 2, 3};
//        solution.combinationSum(testnum, 3);
//    }
    }
}

class Solution39 {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int sum;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backTracing39(candidates, target, 0);
        return ans;
    }

    public void backTracing39(int[] candidates, int target, int startIndex) {
//        if (sum > target) {
//            return;
//        }
        if (sum == target) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            if (sum + candidates[i] > target) {
                break;
            }
            path.add(candidates[i]);
            sum += candidates[i];
            backTracing39(candidates, target, i);
            sum -= candidates[i];
            path.remove(path.size() - 1);
        }
    }
}
