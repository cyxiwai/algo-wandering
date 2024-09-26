package com.xiwai.algorithm.sept.sept26;

public class num240 {
}

class Solution240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        int j = matrix.length - 1;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            }
            if (matrix[i][j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }
}