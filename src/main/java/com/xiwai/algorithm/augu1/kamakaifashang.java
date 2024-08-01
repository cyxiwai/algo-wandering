package com.xiwai.algorithm.augu1;

import java.util.Scanner;

public class kamakaifashang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int sum = 0;
        int[][] nums = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                nums[i][j] = sc.nextInt();
                sum += nums[i][j];
            }
        }
        int[] horizon = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                horizon[i] += nums[i][j];
            }
        }

        int[] vertical = new int[m];
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                vertical[j] += nums[i][j];
            }
        }
        int result=Integer.MAX_VALUE;
        int horizonCut=0;
        int verticalCut=0;

        for(int i=0;i<n;i++)
        {
            horizonCut+=horizon[i];
            result = Math.min(result, Math.abs((sum - horizonCut) - horizonCut));
        }
        for(int j=0;j<m;j++)
        {
            verticalCut+=vertical[j];
            result = Math.min(result, Math.abs((sum - verticalCut) - verticalCut));
        }

        System.out.println(result);
    }

}
