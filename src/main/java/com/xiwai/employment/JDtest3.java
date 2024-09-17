package com.xiwai.employment;

import java.util.Scanner;

public class JDtest3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n][2];
        for (int i = 0; i < n; i++) {
            grid[i][0] = sc.nextInt();
            grid[i][1] = sc.nextInt();
        }
        int maxDIs = 0;
        for (int i = 0; i < n; i++) {
            int disTemp = 0;
            for (int j = i + 1; j < n; j++) {

                disTemp = Math.max(disTemp, (int) (Math.log(2)/(Math.log(Math.abs(grid[i][0] - grid[j][0]) * Math.abs(grid[i][0] - grid[j][0]) + Math.abs(grid[i][1] - grid[j][1]) * Math.abs(grid[i][1] - grid[j][1])))));
            }
            maxDIs = Math.max(disTemp, maxDIs);
        }
        System.out.println(maxDIs % 2 == 1 ? maxDIs / 2 + 1 : maxDIs / 2);
    }
}
