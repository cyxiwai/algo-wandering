package com.xiwai.algorithm.sept.sept21;

public class num59_third {
    public static void main(String[] args) {
        Solution59 s = new Solution59();
        s.generateMatrix(5);
    }
}

class Solution59 {
    public int[][] generateMatrix(int n) {
        int startX = 0;
        int startY = 0;
        int offset = 0;
        int loop = n / 2;
        int num = 1;
        int[][] ans = new int[n][n];
        while (loop-- > 0) {
            for (int i = startX; i < n - offset - 1; i++) {
                ans[offset][i] = num++;
            }
            for (int i = startY; i < n - offset - 1; i++) {
                ans[i][n - offset - 1] = num++;
            }
            for (int i = n - offset - 1; i > offset; i--) {
                ans[n - offset - 1][i] = num++;
            }
            for (int i = n - offset - 1; i > offset; i--) {
                ans[i][offset] = num++;
            }
            offset++;
            startX++;
            startY++;
        }
        if (n % 2 == 1) {
            ans[n / 2][n / 2] = n * n;
        }
        return ans;
    }
}