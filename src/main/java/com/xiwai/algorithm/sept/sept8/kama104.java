package com.xiwai.algorithm.sept.sept8;

import java.util.*;

public class kama104 {
    public static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public static int count = 0;
    public static int area = 0;

    public static void bfs(boolean[][] visited, int[][] grid, int x, int y) {
        Queue<Pair> queue = new LinkedList<Pair>();
        queue.add(new Pair(x, y));
        grid[x][y] += count;
        visited[x][y] = true;
        area++;
        while (!queue.isEmpty()) {
            int curX = queue.peek().first;
            int curY = queue.poll().second;

            for (int i = 0; i < 4; i++) {
                int nextX = curX + dir[i][0];
                int nextY = curY + dir[i][1];
                if (nextX < 0 || nextY < 0 || nextX >= grid.length || nextY >= grid[0].length) continue;
                if (!visited[nextX][nextY] && grid[nextX][nextY] == 1) {
                    queue.add(new Pair(nextX, nextY));
                    visited[nextX][nextY] = true;
                    grid[nextX][nextY] += count;
                    area++;
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
        boolean is_allLand = true;
        while (i < m && sc.hasNextInt()) {
            grid[i][j] = sc.nextInt();
            if (grid[i][j] == 0) {
                is_allLand = false;
            }
            j++;
            if (j == n) {
                j = 0;
                i++;
            }
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int k = 0; k < m; k++) {
            for (int l = 0; l < n; l++) {
                if (!visited[k][l] && grid[k][l] == 1) {
                    count++;
                    area = 0;
                    bfs(visited, grid, k, l);
                    map.put(count + 1, area);
                }
            }
        }
        int result = 0;
        for (int k = 0; k < m; k++) {
            for (int l = 0; l < n; l++) {
                if (grid[k][l] == 0) {
                    Set<Integer> neighboringIslands = new HashSet<>();
                    int combinedArea = 1; // 转化这个水域后新的面积为1

                    for (int d = 0; d < 4; d++) {
                        int nk = k + dir[d][0];
                        int nl = l + dir[d][1];
                        if (nk >= 0 && nl >= 0 && nk < m && nl < n && grid[nk][nl] > 1) {
                            neighboringIslands.add(grid[nk][nl]); // 相邻的岛屿ID
                        }
                    }
                    for (int id : neighboringIslands) {
                        combinedArea += map.get(id);
                    }
                    result = Math.max(result, combinedArea);
                }
            }
        }
        System.out.println(is_allLand ? m * n : result);
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