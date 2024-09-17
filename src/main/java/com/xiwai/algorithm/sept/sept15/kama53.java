package com.xiwai.algorithm.sept.sept15;

import java.util.Scanner;

public class kama53 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dot = sc.nextInt();
        int verTic = sc.nextInt();
        int[][] grid = new int[dot + 1][dot + 1];
        for (int i = 0; i < verTic; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int val = sc.nextInt();
            grid[v1][v2] = val;
            grid[v2][v1] = val;
        }
        for (int i = 0; i < dot + 1; i++) {
            for (int j = 0; j < dot + 1; j++) {
                grid[i][j] = grid[i][j] == 0 ? 10001 : grid[i][j];
            }
        }
        int[] minDist = new int[dot + 1];
        boolean[] isTree = new boolean[dot + 1];
        for (int i = 0; i < dot + 1; i++) {
            minDist[i] = 10001;
        }
        for (int i = 1; i < dot; i++) {
            int cur = -1;
            int minVal = Integer.MAX_VALUE;
            for (int j = 1; j <= dot; j++) {
                if (!isTree[j] && minVal > minDist[j]) {
                    minVal = minDist[j];
                    cur = j;
                }
            }
            isTree[cur] = true;
            for (int j = 1; j <= dot; j++) {
                if (grid[cur][j] < minDist[j] && !isTree[j]) {
                    minDist[j] = grid[cur][j];
                }
            }
        }
        int result = 0;
        for (int i = 2; i <= dot; i++) {
            result += minDist[i];
        }
        System.out.println(result);

    }
}
