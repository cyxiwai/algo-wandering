package com.xiwai.algorithm.sept.sept1;

public class num474 {
    public static void main(String[] args) {
        String[] test = {"10", "0001", "111001", "1", "0"};
        Solution474 s = new Solution474();
        System.out.println(s.findMaxForm(test, 3, 3));
    }
}

class Solution474 {
    private int zeroNum = 0;
    private int oneNum = 0;

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < strs.length; i++) {
            get_zero_one(strs[i]);
            for (int j = m; j >= zeroNum; j--) {
                for (int k = n; k >= oneNum; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - zeroNum][k - oneNum] + 1);
                }
            }
            zeroNum = 0;
            oneNum = 0;
        }
        return dp[m][n];
    }

    public void get_zero_one(String strs) {
        char[] s_toChar = strs.toCharArray();
        for (int i = 0; i < s_toChar.length; i++) {
            if (s_toChar[i] == '0') {
                zeroNum++;
            } else {
                oneNum++;
            }
        }
    }
}