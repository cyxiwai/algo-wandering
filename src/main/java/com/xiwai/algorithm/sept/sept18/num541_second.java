package com.xiwai.algorithm.sept.sept18;

public class num541_second {
}

class Solution541 {
    public String reverseStr(String s, int k) {
        char[] s_toChar = s.toCharArray();
        for (int i = 0; i < s.length(); i += 2 * k) {
            reverseString(s_toChar, i, i + k - 1);
        }
        return new String(s_toChar);
    }

    public void reverseString(char[] s, int lef, int righ) {
        int left = lef;
        int right = Math.min(righ, s.length - 1);
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
