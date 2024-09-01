package com.xiwai.algorithm.augu.augu29;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class num56 {
    public static void main(String[] args) {
        int[][] test = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
//        Solution solution = new Solution();
//        solution.merge(test);
    }
}

class Solution56 {
    public int[][] merge(int[][] intervals) {
        List<List<Integer>> ansL = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int index = intervals[0][1];
        List<Integer> path = new ArrayList<>();
        path.add(intervals[0][0]);
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] > index) {
                path.add(index);
                index = intervals[i][1];
                ansL.add(new ArrayList<>(path));
                path.clear();
                path.add(intervals[i][0]);//总区间大，先加入左区间，右区间待定
            } else {
                index = Math.max(index, intervals[i][1]);
            }
        }
        path.add(index);
        ansL.add(path);
        int[][] ans = new int[ansL.size()][2];
        for (int i = 0; i < ansL.size(); i++) {
            ans[i][0] = ansL.get(i).get(0);
            ans[i][1] = ansL.get(i).get(1);
        }
        return ans;
    }
}