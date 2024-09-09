package com.xiwai.algorithm.sept.sept7;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class kama102 {
    public static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public static int area = 0;

    public static void bfs(boolean[][] visited, int[][] grid, int x, int y) {
        Queue<Pair> queue = new LinkedList<Pair>();
        queue.add(new Pair(x, y));
        visited[x][y] = true;
        area++;
        while (!queue.isEmpty()) {
            int curX = queue.peek().first;
            int curY = queue.poll().second;
            for (int i = 0; i < 4; i++) {
                int nextX = curX + dir[i][0];
                int nextY = curY + dir[i][1];
                if (nextX < 0 || nextY < 0 || nextX >= grid.length || nextY >= grid[0].length) {
                    continue;
                }
                if (!visited[nextX][nextY] && grid[nextX][nextY] == 1) {
                    queue.add(new Pair(nextX, nextY));
                    visited[nextX][nextY] = true;
                    area++;
                }
            }
            if (area == 1) {
                grid[curX][curY] = 0;
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
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    area = 0;
                    bfs(visited, grid, i, j);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }


    }
}

class Pair {
    protected int first;
    protected int second;

    public Pair() {
    }

    public Pair(int x, int y) {
        this.first = x;
        this.second = y;
    }
}