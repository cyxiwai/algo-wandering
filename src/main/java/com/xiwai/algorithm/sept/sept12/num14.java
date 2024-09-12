package com.xiwai.algorithm.sept.sept12;

import java.util.Arrays;

public class num14 {
    public static void main(String[] args) {
        Solution14 s = new Solution14();
        String[] test = {"", "flow", "flight"};
        System.out.println(s.longestCommonPrefix(test));
    }
}

class Solution14 {
    public String longestCommonPrefix(String[] strs) {
        int maxSize = Integer.MIN_VALUE;

        for (String str : strs) {
            if (str.length() == 0) {
                return "";
            }
            maxSize = Math.max(str.length(), maxSize);
        }
        int count = 0;
        for (int i = 0, j = 0; i < maxSize; i++) {
            count++;
            char temp = strs[0].charAt(i);
            for (j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != temp) {
                    count--;
                    break;
                }
            }
            if (j != strs.length) {
                break;
            }
        }
        return count > 0 ? strs[0].substring(0, count) : "";
    }

}
