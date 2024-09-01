package com.xiwai.algorithm.sept.sept1;

public class num518 {
    public static void main(String[] args) {
        int[] test = {1, 2, 3};
        Solution518 s = new Solution518();
        System.out.println(s.change(4, test));
    }
}

class Solution518 {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }
}