package com.xiwai.algorithm.augu30;

import java.util.Scanner;

public class kama57 {
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] dp = new int[n + 1];
            dp[0] = 1;
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < m + 1; j++) {
                    if (i >= j) {
                        dp[i] += dp[i - j];
                    }
                }
            }
            System.out.println(dp[n]);
    }
}
