package com.xiwai.algorithm.sept.sept26;

import java.util.ArrayList;
import java.util.List;

public class num54 {
}

class Solution54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int leftBorder = 0;
        int rightBorder = matrix[0].length - 1;
        int upBorder = 0;
        int downBorder = matrix.length - 1;
        List<Integer> list = new ArrayList<>();
        while (true) {
            for (int i = leftBorder; i <= rightBorder; i++) {
                list.add(matrix[upBorder][i]);
            }
            if (++upBorder > downBorder) break;
            for (int i = upBorder; i <= downBorder; i++) {
                list.add(matrix[i][rightBorder]);
            }
            if (--rightBorder < leftBorder) break;
            for (int i = rightBorder; i >= leftBorder; i--) {
                list.add(matrix[downBorder][i]);
            }
            if (--downBorder < upBorder) break;
            for (int i = downBorder; i >= upBorder; i--) {
                list.add(matrix[i][leftBorder]);
            }
            if (++leftBorder > rightBorder) break;
        }
        return list;
    }
}

