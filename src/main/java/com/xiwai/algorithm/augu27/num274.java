package com.xiwai.algorithm.augu27;

import java.util.Arrays;

public class num274 {
}

class Solution {
    public int hIndex(int[] citations) {
        int ans = 0;

        Arrays.sort(citations);
        if (citations.length == 1) {
            if (citations[0] != 0) {
                ans = 1;
            }
        }
        for (int i = citations.length - 1; i >= 0; i--) {
            if (citations[i] <= citations.length - i) {
                ans = Math.max(citations[i], ans);
                break;
            } else {
                ans = citations.length - i;
            }
        }
        return Math.min(citations.length, ans);
    }
}