package com.xiwai.algorithm.augu30;

public class num509 {
}

class Solution509 {
    public int fib(int n) {
        int[] DP = new int[Math.max(n + 1, 3)];
        DP[0] = 0;
        DP[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            DP[i] = DP[i - 1] + DP[i - 2];
        }
        return DP[n];
    }
}