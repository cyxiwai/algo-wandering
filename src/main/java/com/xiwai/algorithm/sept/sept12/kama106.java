package com.xiwai.algorithm.sept.sept12;

import java.util.Scanner;

public class kama106 {
    public static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] grid = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    for (int k = 0; k < 4; k++) {
                        int nextX = i + dir[k][0];
                        int nextY = j + dir[k][1];
                        if (nextX >= m || nextX < 0) {
                            res += 1;
                        }
                        if (nextY >= n || nextY < 0) {
                            res += 1;
                        }
                        if (nextX < m && nextX >= 0
                                && nextY >= 0 && nextY < n && grid[nextX][nextY] == 0) {
                            res += 1;
                        }
                    }
                }
            }
        }
        System.out.println(res);
    }
}
