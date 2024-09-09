package com.xiwai.algorithm.sept.sept8;

import java.util.Scanner;

public class kama103 {
    public static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void dfs(boolean[][] visited, int[][] grid, int x, int y) {
        if (visited[x][y]) {
            return;
        }
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nextX = x + dir[i][0];
            int nextY = y + dir[i][1];
            if (nextX < 0 || nextY < 0 || nextX >= grid.length || nextY >= grid[0].length)
                continue;
            if (grid[x][y] > grid[nextX][nextY])
                continue;
            dfs(visited, grid, nextX, nextY);
        }
        return;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] grid = new int[m][n];
        boolean[][] first_border = new boolean[m][n];
        boolean[][] second_border = new boolean[m][n];
        int i = 0, j = 0;
        while (i < m && sc.hasNextInt()) {
            grid[i][j] = sc.nextInt();
            j++;
            if (j == n) {
                j = 0;
                i++;
            }
        }
        for (int k = 0; k < m; k++) {
            dfs(first_border, grid, k, 0);
            dfs(second_border, grid, k, n - 1);
        }
        for (int k = 0; k < n; k++) {
            dfs(first_border, grid, 0, k);
            dfs(second_border, grid, m - 1, k);
        }
        for (int k = 0; k < m; k++) {
            for (int l = 0; l < n; l++) {
                if (first_border[k][l] && second_border[k][l]) {
                    System.out.println(k + " " + l);
                }
            }
        }

    }
}
