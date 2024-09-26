package com.xiwai.algorithm.sept.sept26;

import java.util.Arrays;
import java.util.Scanner;

public class kama47 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n + 1][n + 1];
        int[] minDist = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(grid[i], Integer.MAX_VALUE);
        }
        Arrays.fill(minDist, Integer.MAX_VALUE);
        for (int i = 0; i < m; i++) {
            int s = sc.nextInt();
            int t = sc.nextInt();
            int val = sc.nextInt();
            grid[s][t] = val;
//            grid[t][s] = val;
        }//Initialization
        int start = 1;
        int end = n;
        minDist[start] = 0;
        for (int i = 1; i <= n; i++) {
            int cur = 1;
            int minVal = Integer.MAX_VALUE;
            for (int j = 1; j <= n; j++) {
                if (!visited[j] && minDist[j] < minVal) {
                    cur = j;
                    minVal = minDist[j];
                }
            }
            visited[cur] = true;
            for (int j = 1; j <= n; j++) {
                if (grid[cur][j] != Integer.MAX_VALUE && !visited[j] && minDist[j] > grid[cur][j] + minDist[cur]) {
                    minDist[j] = grid[cur][j] + minDist[cur];
                }
            }
        }
        if (minDist[end] == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(minDist[end]);
        }
    }
}
