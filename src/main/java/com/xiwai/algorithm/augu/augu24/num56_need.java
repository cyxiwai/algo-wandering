//package com.xiwai.algorithm.augu24;
//
//import java.util.Arrays;
//
//public class num56_need {
//}
//
//class Solution {
//
//    public int[][] merge(int[][] intervals) {
//        if (intervals.length == 2) {
//            if (intervals[0][1] == intervals[1][0]) {
//                int[][] ans = new int[1][2];
//                ans[0][0] = intervals[0][0];
//                ans[0][1] = intervals[1][1];
//                return ans;
//            } else
//                return intervals;
//        }
//        int[][] ans = new int[intervals.length][2];
//
//        int ans_row_index = 0;
//        int[] temp = intervals[0];
//        for (int i = 1; i < intervals.length; i++) {
//            if (intervals[i][0] < temp[1]) {
//                temp[1] = Math.max(temp[1], intervals[i][1]);
//                ans[ans_row_index] = temp;
//            } else {
//                ans_row_index++;
//                temp = intervals[i];
//            }
//            ans[ans_row_index] = temp;
//        }
//        return Arrays.copyOf(ans, ans_row_index + 1);
//    }
//}
