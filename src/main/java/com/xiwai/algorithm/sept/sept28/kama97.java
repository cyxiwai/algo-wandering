package com.xiwai.algorithm.sept.sept28;

import java.util.Arrays;
import java.util.Scanner;

public class kama97 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][][] grid = new int[n + 1][n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k <= n; k++) {
                    Arrays.fill(grid[i][j], 10005);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt(), v = sc.nextInt(), val = sc.nextInt();
            grid[u][v][0] = val;
            grid[v][u][0] = val;
        }
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    grid[i][j][k] = Math.min(grid[i][j][k - 1], grid[i][k][k - 1] + grid[k][j][k - 1]);
                }
            }
        }
        int times = sc.nextInt();
        while (times-- > 0) {
            int start = sc.nextInt(), end = sc.nextInt();
            if (grid[start][end][n] == 10005) System.out.println(-1);
            else {
                System.out.println(grid[start][end][n]);
            }
        }
    }
}
