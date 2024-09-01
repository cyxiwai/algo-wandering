package com.xiwai.algorithm.augu.augu21;

import java.util.ArrayList;
import java.util.List;

public class num216 {
    public static void main(String[] args) {
//        Solution solution = new Solution();
//        solution.combinationSum3(3, 7);
    }
}

class Solution216 {
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    int sum = 0;

    public List<List<Integer>> combinationSum3(int k, int n) {
        backTracing216(k, n, 1);
        return ans;
    }

    public void backTracing216(int k, int n, int startIndex) {
        if (sum > n) {
            return;
        }
        if (path.size() == k) {
            if (sum == n) {
                ans.add(new ArrayList<>(path));
            }
            return;
        }
        for (int i = startIndex; i <= 9 - k + 1 + path.size(); i++) {
            path.add(i);
            sum += i;
            backTracing216(k, n, i + 1);
            sum -= i;
            path.remove(path.size() - 1);
        }

    }
}