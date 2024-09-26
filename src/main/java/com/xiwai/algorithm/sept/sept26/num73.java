package com.xiwai.algorithm.sept.sept26;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class num73 {
}

class Solution73 {
    public void setZeroes(int[][] matrix) {
        Set<Integer> setRow = new HashSet<>();
        Set<Integer> setList = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    setRow.add(i);
                    setList.add((j));
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            if (setRow.contains(i)) {
                Arrays.fill(matrix[i], 0);
            }
        }
        for (int i = 0; i < matrix[0].length; i++) {
            if (setList.contains(i)) {
                for (int j = 0; j < matrix.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
    }
}