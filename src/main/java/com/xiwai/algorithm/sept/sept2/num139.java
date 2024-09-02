package com.xiwai.algorithm.sept.sept2;

import java.util.HashSet;
import java.util.List;

public class num139 {
}

class Solution139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        HashSet<String> set = new HashSet<>(wordDict);
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j <= i && !dp[i]; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }
}
