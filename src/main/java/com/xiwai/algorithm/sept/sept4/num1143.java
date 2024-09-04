package com.xiwai.algorithm.sept.sept4;

public class num1143 {
    public static void main(String[] args) {

        Solution1143 s = new Solution1143();
        System.out.println(s.longestCommonSubsequence("abcde", "ace"));
    }
}

class Solution1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        //dp数组表示当前最大的公共字串长度，ij表示字符串12的第ij个，因此如果第i个=第j个，那么dpij=dpi-1j-1
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
}