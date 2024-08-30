package com.xiwai.algorithm.augu30;

public class num70 {
}

class Solution70 {
    public int climbStairs(int n) {
        int[] DP = new int[Math.max(3, n + 1)];
        DP[0] = 0;
        DP[1] = 1;
        DP[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            DP[i] = DP[i - 1] + DP[i - 2];
        }
        return DP[n];
    }
}
