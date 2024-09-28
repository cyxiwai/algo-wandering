package com.xiwai.algorithm.sept.sept24;

public class num79 {
}

class Solution {
    public String minWindow(String s, String t) {
        int left = 0;
        int ansLeft = -1;
        int ansRight = s.length();
        int less = 0;
        int[] cnt = new int[128];
        for (char c : t.toCharArray()) {
            if (cnt[c] == 0) {
                less++;
            }
            cnt[c]++;
        }
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            cnt[c]--;
            if (cnt[c] == 0) {
                less--;
            }
            while (less == 0) {
                if (right - left < ansRight - ansLeft) {
                    ansLeft = left;
                    ansRight = right;
                }
                char x = s.charAt(left);
                if (cnt[x] == 0) {
                    less++;
                }
                cnt[x]++;
                left++;
            }
        }
        return ansLeft < 0 ? "" : s.substring(ansLeft, ansRight + 1);
    }
}