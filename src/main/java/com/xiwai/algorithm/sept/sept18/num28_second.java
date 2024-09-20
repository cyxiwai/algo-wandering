package com.xiwai.algorithm.sept.sept18;

public class num28_second {
    public static void main(String[] args) {
        Solution28 s = new Solution28();
        System.out.println(s.strStr("sadaboutsi", "sad"));
    }
}

class Solution28 {
    public int strStr(String haystack, String needle) {
        int flag = -1;
        if (needle.length() > haystack.length()) {
            return flag;
        }
        int[] pi = new int[haystack.length() + needle.length() + 1];
        String plu = needle + "#" + haystack;
        for (int i = 1; i < pi.length; i++) {
            int len = pi[i - 1];
            while (len != 0 && plu.charAt(i) != plu.charAt(len)) {
                len = pi[len - 1];
            }
            if (plu.charAt(i) == plu.charAt(len)) {
                pi[i] = len + 1;
            }
        }
        for (int i = 0; i < pi.length; i++) {
            if (pi[i] == needle.length()) {
                flag = i - 2 * needle.length();
                break;
            }
        }
        return flag;
    }
}
