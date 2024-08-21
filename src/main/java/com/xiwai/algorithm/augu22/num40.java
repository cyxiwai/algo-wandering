package com.xiwai.algorithm.augu22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class num40 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] testNums = {1, 1, 2, 3, 3, 5, 6, 7, 10};
//        for (List<Integer> list : solution.combinationSum2(testNums, 8)) {
            System.out.println("next");
//            for (int i : list) {
//                System.out.println(i);
            }
        }
    }
}

//解法二：
class Solution40 {
    LinkedList<Integer> path = new LinkedList<>();
    List<List<Integer>> ans = new ArrayList<>();
    boolean[] used;
    int sum = 0;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        used = new boolean[candidates.length];
        // 加标志数组，用来辅助判断同层节点是否已经遍历
        Arrays.fill(used, false);
        // 为了将重复的数字都放到一起，所以先进行排序
        Arrays.sort(candidates);
        backTracking(candidates, target, 0);
        return ans;
    }

    private void backTracking(int[] candidates, int target, int startIndex) {
        if (sum == target) {
            ans.add(new ArrayList(path));
        }
        for (int i = startIndex; i < candidates.length; i++) {
            if (sum + candidates[i] > target) {
                break;
            }
            // 出现重复节点，同层的第一个节点已经被访问过，所以直接跳过
            if (i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            sum += candidates[i];
            path.add(candidates[i]);
            // 每个节点仅能选择一次，所以从下一位开始
            backTracking(candidates, target, i + 1);
            used[i] = false;
            sum -= candidates[i];
            path.removeLast();
        }
    }
}


//
//class Solution {
//    List<Integer> path = new ArrayList<>();
//    int sum = 0;
//    List<List<Integer>> ans = new ArrayList<>();
//
//    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
//        Arrays.sort(candidates);
//        backTracing(candidates, target, 0);
//        return ans;
//    }
//
//    public void backTracing(int[] candidates, int target, int startIndex) {
//        if (sum == target) {
//            ans.add(new ArrayList<>(path));
//            return;
//        }
//        for (int i = startIndex; i < candidates.length; i++) {
//
//            if(sum + candidates[i] > target)
//            {
//                break;
//            }
//            if (i > startIndex && candidates[i] == candidates[i - 1]) {
//                continue;
//            }
//            sum += candidates[i];
//            path.add(candidates[i]);
//            backTracing(candidates, target, i + 1);
//            sum -= path.get(path.size() - 1);
//            path.remove(path.size() - 1);
//        }
//    }
//}
