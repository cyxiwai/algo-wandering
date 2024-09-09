package com.xiwai.employment;

import java.util.Arrays;
import java.util.Scanner;

public class test4 {

    public static int[][] dir = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] grid = new char[n][m];
        int[][] grid_stat = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < m; j++) {
                grid[i][j] = s.charAt(j);
            }
        }
        int true_count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 'L' && j - 1 < 0) {
                    grid_stat[i][j] = 1;
                    visited[i][j] = true;
                    true_count++;
                }
                if (grid[i][j] == 'R' && j + 1 > m - 1) {
                    visited[i][j] = true;
                    true_count++;
                    grid_stat[i][j] = 1;
                }
                if (grid[i][j] == 'U' && i - 1 < 0) {
                    visited[i][j] = true;
                    true_count++;
                    grid_stat[i][j] = 1;
                }
                if (grid[i][j] == 'D' && i + 1 > n - 1) {
                    visited[i][j] = true;
                    true_count++;
                    grid_stat[i][j] = 1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid_stat[i][j] == 1) {
                    continue;
                }
                int nx = i;
                int ny = j;
                while (!visited[nx][ny]) {

                    switch (grid[nx][ny]) {
                        case 'L':
                            if (ny - 1 > 0 && grid[nx][ny - 1] == 'R') {
                                visited[nx][ny] = true;
                            }
                            ny--;
                            break;
                        case 'R':
                            if (ny + 1 < n - 1 && grid[nx][ny + 1] == 'L') {
                                visited[nx][ny] = true;
                            }
                            ny++;
                            break;
                        case 'U':
                            if (nx - 1 > 0 && grid[nx - 1][ny] == 'D') {
                                visited[nx][ny] = true;
                            }
                            nx--;
                            break;
                        case 'D':
                            if (nx + 1 < m - 1 && grid[nx + 1][ny] == 'U') {
                                visited[nx][ny] = true;
                            }
                            nx++;
                            break;
                    }
                    if (nx < 0 || ny < 0 || nx >= grid.length || ny >= grid[0].length) {
                        break;
                    }
                }
                visited[i][j] = true;
                if (grid_stat[nx][ny] == 1) {
                    grid_stat[i][j] = 1;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid_stat[i][j] == 1) {
                    count++;
                }
            }
        }
        System.out.println(m * n - count);
    }
}
