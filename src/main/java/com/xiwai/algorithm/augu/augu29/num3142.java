package com.xiwai.algorithm.augu.augu29;

public class num3142 {
    public static void main(String[] args) {
        int[][] test = {{2, 7}, {2, 2}};
        Solution3142 s = new Solution3142();
        System.out.println(s.satisfiesConditions(test));
    }
}

class Solution3142 {

    public boolean satisfiesConditions(int[][] grid) {
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (i + 1 < grid.length && grid[i][j] != grid[i + 1][j]) {
                    return false;
                }
                if (j + 1 < grid[0].length && grid[i][j] == grid[i][j + 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}


