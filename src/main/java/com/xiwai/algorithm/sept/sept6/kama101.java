package com.xiwai.algorithm.sept.sept6;



import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class kama101 {
    public static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void bfs(int[][] grid, int x, int y) {
        Queue<pair> queue = new LinkedList<pair>();
        queue.add(new pair(x, y));
        grid[x][y] = 0;
        while (!queue.isEmpty()) {
            int curX = queue.peek().first;
            int curY = queue.poll().second;
            for (int i = 0; i < 4; i++) {
                int nextX = curX + dir[i][0];
                int nextY = curY + dir[i][1];
                if (nextY < 0 || nextX < 0 || nextX >= grid.length || nextY >= grid[0].length) {
                    continue;
                }
                if (grid[nextX][nextY] == 1) {
                    queue.add(new pair(nextX, nextY));
                    grid[nextX][nextY] = 0;
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
        int i = 0, j = 0;
        while (sc.hasNextInt() && i < m) {
            grid[i][j] = sc.nextInt();
            j++;
            if (j == n) {
                j = 0;
                i++;
            }
        }

        int ans = 0;

        for (i = 0; i < m; i++) {
            if (grid[i][0] == 1) {
                bfs(grid, i, 0);
            }
            if (grid[i][n - 1] == 1) {
                bfs(grid, i, n - 1);
            }
        }
        for (i = 0; i < n; i++) {
            if (grid[0][i] == 1) {
                bfs(grid, 0, i);
            }
            if (grid[m - 1][i] == 1) {
                bfs(grid, m - 1, i);
            }
        }
        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
}

class pair {
    public int first;
    public int second;

    public pair() {
    }

    public pair(int x, int y) {
        this.first = x;
        this.second = y;
    }
}