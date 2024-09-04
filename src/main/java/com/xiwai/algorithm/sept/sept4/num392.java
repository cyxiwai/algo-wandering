package com.xiwai.algorithm.sept.sept4;

public class num392 {
    public static void main(String[] args) {
        Solution392 s = new Solution392();
        System.out.println(s.isSubsequence("abc", "ahbgbc"));

    }
}

class Solution392 {
    public boolean isSubsequence(String s, String t) {
        int[][] dp = new int[t.length() + 1][s.length() + 1];
        for (int i = 1; i <= t.length(); i++) {
            for (int j = 1; j <= s.length(); j++) {
                if (t.charAt(i - 1) == s.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[t.length()][s.length()] == s.length();
    }
}