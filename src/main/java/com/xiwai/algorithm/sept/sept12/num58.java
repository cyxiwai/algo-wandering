package com.xiwai.algorithm.sept.sept12;

public class num58 {
    public static void main(String[] args) {
        Solution58 s = new Solution58();
        System.out.println(s.lengthOfLastWord("Hello World"));
    }
}

class Solution58 {
    public int lengthOfLastWord(String s) {
        char[] s_toChar = s.toCharArray();
        int count = 0;
        int i = s_toChar.length - 1;
        while (i >= 0 && s_toChar[i] == ' ') {
            i--;
        }
        for (; i >= 0; i--) {

            if (s_toChar[i] != ' ') {
                count++;
            } else {
                break;
            }
        }
        return count;
    }
}
