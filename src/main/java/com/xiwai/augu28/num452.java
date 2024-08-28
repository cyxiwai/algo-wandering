package com.xiwai.augu28;

import com.sun.javaws.jnl.IconDesc;

import java.util.Arrays;

public class num452 {
    public static void main(String[] args) {
//        Solution solution = new Solution();
        int[][] points = {{3, 9}, {7, 12}, {3, 8}, {6, 8}, {9, 10}, {2, 9}, {0, 9}, {3, 9}, {0, 6}, {2, 8}};

//        System.out.println(solution.findMinArrowShots(points));
    }
}
class Solution452 {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        int count = 0;
        long index = Long.MIN_VALUE;
        for (int i = 0; i < points.length; i++) {
            if (index < points[i][0]) {
                count++;
                index = points[i][1];
            } else {
                index = Math.min(index, points[i][1]);
            }
        }
        return count == 0 ? count + 1 : count;
    }
}