package com.xiwai.algorithm.sept.sept18;

import java.util.Arrays;

public class num151_second {
    public static void main(String[] args) {
        Solution151 s = new Solution151();
        s.reverseWords("a good   example");
    }
}

class Solution151 {
    public String reverseWords(String s) {
        char[] s_toChar = s.toCharArray();
        char[] ans = removeExtraSpaces(s_toChar);
        reverse(ans, 0, ans.length - 1);
        reverseEachWord(ans);
        return new String(ans);
    }

    public void reverseEachWord(char[] chars) {
        int start = 0;
        for (int end = 0; end <= chars.length; end++) {
            if (end == chars.length || chars[end] == ' ') {
                reverse(chars, start, end - 1);
                start = end + 1;
            }
        }
    }

    public void reverse(char[] chars, int left, int right) {
        if (right >= chars.length) {
            return;
        }
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }

    public char[] removeExtraSpaces(char[] chars) {
        int slow = 0;
        for (int fast = 0; fast < chars.length; fast++) {
            if (chars[fast] != ' ') {
                if (slow != 0) {
                    chars[slow++] = ' ';
                }
                while (fast < chars.length && chars[fast] != ' ') {
                    chars[slow++] = chars[fast++];
                }
            }
        }
        return Arrays.copyOfRange(chars, 0, slow);
    }
}
