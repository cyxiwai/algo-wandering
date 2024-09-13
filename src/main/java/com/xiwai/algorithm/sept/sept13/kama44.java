package com.xiwai.algorithm.sept.sept13;

import java.util.Scanner;

public class kama44 {
    public static void main(String[] args) {
        int sum = 0;
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[] areaUD = new int[m];
        int[] areaLR = new int[n];
        int[][] grid = new int[m][n];
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
                count += grid[i][j];
            }
            areaUD[i] = count;
        }
        count = 0;
        sum = areaUD[m - 1];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                count += grid[i][j];
            }
            areaLR[j] = count;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            if (areaUD[i] >= sum / 2) {
                min = Math.min(min, areaUD[i] * 2 - sum);
            } else {
                min = Math.min(min, sum - areaUD[i] * 2);
            }
        }
        for (int i = 0; i < n; i++) {
            if (areaLR[i] >= sum / 2) {
                min = Math.min(min, areaLR[i] * 2 - sum);
            } else {
                min = Math.min(min, sum - areaLR[i] * 2);
            }
        }
        System.out.println(min);
    }
}
