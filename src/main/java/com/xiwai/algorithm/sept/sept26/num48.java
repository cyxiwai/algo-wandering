package com.xiwai.algorithm.sept.sept26;

public class num48 {
    public static void main(String[] args) {
        int[][] test = {{1, 2}, {3, 4}};
        Solution s = new Solution();
        s.rotate(test);
    }
}

class Solution {
    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length / 2; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                swap(matrix, i, j, matrix.length - 1 - i, j);
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                swap(matrix, i, j, j, i);
            }
        }
    }

    public void swap(int[][] matrix, int x1, int y1, int x2, int y2) {
        int temp = matrix[x1][y1];
        matrix[x1][y1] = matrix[x2][y2];
        matrix[x2][y2] = temp;
    }
}
