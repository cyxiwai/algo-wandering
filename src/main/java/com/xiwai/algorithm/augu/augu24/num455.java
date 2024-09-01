package com.xiwai.algorithm.augu.augu24;

import java.util.Arrays;

public class num455 {
}

class Solution455 {
    int ans = 0;

    public int findContentChildren(int[] g, int[] s) {
        if (s.length == 0) {
            return ans;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        int index = s.length - 1;
        for (int i = g.length - 1; i >= 0; i--) {
            if (index >= 0 && s[index] >= g[i]) {
                ans++;
                index--;
            }
        }

        return ans;
    }
}