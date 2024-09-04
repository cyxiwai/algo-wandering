package com.xiwai.algorithm.sept.sept4;

import java.beans.PropertyEditorSupport;

public class num647 {
}

class Solution647 {
    public int countSubstrings(String s) {
        int ans = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        //若ij元素不想等，则直接pass，若相等，分三种情况，1 i=j true 2 i=j+1 true 3 ij相差很远，则看i+1，j-1
//        状态转移方程如下 if(s.charAt(i-1)==s.charAt(j-1))]
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 1) {
                        ans++;
                        dp[i][j] = true;
                    } else if (dp[i + 1][j - 1]) {
                        ans++;
                        dp[i][j] = true;
                    }
                }
            }
        }

        return ans;
    }
}
