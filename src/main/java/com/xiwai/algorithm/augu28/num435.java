package com.xiwai.algorithm.augu28;

import java.util.Arrays;

public class num435 {
    public static void main(String[] args) {
        Solution435 s = new Solution435();
        int[][] test ={{1,2},{1,3},{2,3},{3,4}};
        System.out.println(s.eraseOverlapIntervals(test));
    }
}

class Solution435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int count = 0;
        int index = Integer.MIN_VALUE;
        for (int i = 0; i < intervals.length; i++) {
            if (index <= intervals[i][0]) {
                count++;
                index = intervals[i][1];
            } else {
                index = Math.min(index, intervals[i][1]);
            }
        }
        return intervals.length-count;
    }
}
