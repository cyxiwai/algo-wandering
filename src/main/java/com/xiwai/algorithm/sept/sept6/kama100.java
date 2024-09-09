package com.xiwai.algorithm.sept.sept6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class kama100 {
    public static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public static int area = 0;

    public static void bfs(boolean[][] visited, int[][] grid, int x, int y) {
        Queue<pair> queue = new LinkedList<pair>();
        queue.add(new pair(x, y));
        visited[x][y] = true;
        area++;
        while (!queue.isEmpty()) {

            int curX = queue.peek().first;
            int curY = queue.poll().second;
            for (int i = 0; i < 4; i++) {
                int nextX = curX + dir[i][0];
                int nextY = curY + dir[i][1];
                if (nextY < 0 || nextX < 0 || nextX >= grid.length || nextY >= grid[0].length) {
                    continue;
                }
                if (!visited[nextX][nextY] && grid[nextX][nextY] == 1) {
                    area++;
                    visited[nextX][nextY] = true;
                    queue.add(new pair(nextX, nextY));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] grid = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    area = 0;
                    bfs(visited, grid, i, j);
                    ans = Math.max(ans, area);
                }
            }
        }
        System.out.println(ans);
    }
}
