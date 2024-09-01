package com.xiwai.algorithm.augu.augu30;

public class num3 {
    public static void main(String[] args) {
        Solution3 s = new Solution3();
        System.out.println(s.lengthOfLongestSubstring("aabcd"));
    }
}

class Solution3 {
    public int lengthOfLongestSubstring(String s) {

        int[] alpha = new int[128];
        if (s.isEmpty()) {
            return 0;
        }
        char[] s_toChar = s.toCharArray();
        int count = 0;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (alpha[s_toChar[i] - ' '] != 0) {
                ans = Math.max(ans, count);
                count = 0;
            }
            alpha[s_toChar[i] - ' ']++;
            count++;
        }
        return Math.max(ans, count);
    }
}