package com.xiwai.algorithm.sept.sept18;

import java.util.Locale;

public class num459 {
    public static void main(String[] args) {
        Solution459 s = new Solution459();
        s.repeatedSubstringPattern("ababac");
    }
}

class Solution459 {
    public boolean repeatedSubstringPattern(String s) {
        int[] pi = new int[s.length()];
        for (int i = 1; i < pi.length; i++) {
            int len = pi[i - 1];
            while (len != 0 && s.charAt(len) != s.charAt(i)) {
                len = pi[len - 1];
            }
            if (s.charAt(len) == s.charAt(i)) {
                pi[i] = len + 1;
            }
        }
        String test2= s.toLowerCase(Locale.ROOT);
        int maxPi = 0;
        for (int i = 0; i < pi.length; i++) {
            maxPi = Math.max(maxPi, pi[i]);
        }
        if (pi[pi.length-1]>0&&s.length() % (s.length() - maxPi) == 0) {
            return true;
        } else {
            return false;
        }
    }
}
