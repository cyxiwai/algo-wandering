package com.xiwai.algorithm.sept.sept6;

import java.util.*;

public class kama99 {
    public static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};//下右上左逆时针遍历

    public static void bfs(int[][] grid, boolean[][] visited, int x, int y) {
        Queue<pair> queue = new LinkedList<pair>();//定义坐标队列，没有现成的pair类，在下面自定义了
        queue.add(new pair(x, y));
        visited[x][y] = true;//遇到入队直接标记为优先，
        // 否则出队时才标记的话会导致重复访问，比如下方节点会在右下顺序的时候被第二次访问入队
        while (!queue.isEmpty()) {
            int curX = queue.peek().first;
            int curY = queue.poll().second;//当前横纵坐标
            for (int i = 0; i < 4; i++) {
                //顺时针遍历新节点next，下面记录坐标
                int nextX = curX + dir[i][0];
                int nextY = curY + dir[i][1];
                if (nextX < 0 || nextX >= grid.length || nextY < 0 || nextY >= grid[0].length) {
                    continue;
                }//去除越界部分
                if (!visited[nextX][nextY] && grid[nextX][nextY] == 1) {
                    queue.add(new pair(nextX, nextY));
                    visited[nextX][nextY] = true;//逻辑同上
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
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    ans++;
                    bfs(grid, visited, i, j);
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