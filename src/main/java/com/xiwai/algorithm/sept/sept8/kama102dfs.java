package com.xiwai.algorithm.sept.sept8;

import java.util.Scanner;

public class kama102dfs {
    public static int[][] dir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public static void dfs(boolean[][] visited, int[][] grid, int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nextX = x + dir[i][0];
            int nextY = y + dir[i][1];
            if (nextX < 0 || nextY < 0 || nextX >= grid.length || nextY >= grid[0].length)
                continue;
            if (!visited[nextX][nextY] && grid[nextX][nextY] == 1) {
                grid[nextX][nextY]++;
                visited[nextX][nextY] = true;
                dfs(visited, grid, nextX, nextY);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] grid = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        int i = 0, j = 0;
        while (sc.hasNextInt() && i < m) {
            grid[i][j] = sc.nextInt();
            j++;
            if (j == n) {
                j = 0;
                i++;
            }
        }
        for (int k = 0; k < m; k++) {
            if (!visited[k][0] && grid[k][0] == 1) {
                grid[k][0]++;
                visited[k][0] = true;
                dfs(visited, grid, k, 0);
            }
            if (!visited[k][n - 1] && grid[k][n - 1] == 1) {
                grid[k][n - 1]++;
                visited[k][n - 1] = true;
                dfs(visited, grid, k, n - 1);
            }
        }
        for (int k = 0; k < n; k++) {
            if (!visited[0][k] && grid[0][k] == 1) {
                grid[0][k]++;
                visited[0][k] = true;
                dfs(visited, grid, 0, k);
            }
            if (!visited[m - 1][k] && grid[m - 1][k] == 1) {
                grid[m - 1][k]++;
                visited[m - 1][k] = true;
                dfs(visited, grid, m - 1, k);
            }
        }
        for (int k = 0; k < m; k++) {
            for (int l = 0; l < n; l++) {
                if (grid[k][l] == 0) {
                    System.out.print(grid[k][l] + " ");
                    continue;
                } else {
                    grid[k][l]--;
                }
                System.out.print(grid[k][l] + " ");
            }
            System.out.println();
        }
    }
}
