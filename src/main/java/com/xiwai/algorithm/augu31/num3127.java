package com.xiwai.algorithm.augu31;

public class num3127 {
}

class Solution3127 {
    public boolean canMakeSquare(char[][] grid) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (is_leftUp(grid, i, j) || is_rightUp(grid, i, j) || is_leftDown(grid, i, j) ||
                        is_rightDown(grid, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean is_leftUp(char[][] grid, int i, int j) {
        if (i > 1 || j > 1) {
            return false;
        } else {
            return grid[i][j + 1] == grid[i + 1][j + 1] && grid[i + 1][j + 1] == grid[i + 1][j];
        }
    }

    public boolean is_rightUp(char[][] grid, int i, int j) {
        if (i > 1 || j < 1) {
            return false;
        } else {
            return grid[i][j - 1] == grid[i + 1][j - 1] && grid[i + 1][j - 1] == grid[i + 1][j];
        }
    }

    public boolean is_leftDown(char[][] grid, int i, int j) {
        if (i < 1 || j > 1) {
            return false;
        } else {
            return grid[i - 1][j + 1] == grid[i][j + 1] && grid[i][j + 1] == grid[i - 1][j];
        }
    }

    public boolean is_rightDown(char[][] grid, int i, int j) {
        if (i < 1 || j < 1) {
            return false;
        } else {
            return grid[i][j - 1] == grid[i - 1][j - 1] && grid[i - 1][j - 1] == grid[i - 1][j];
        }
    }
}
