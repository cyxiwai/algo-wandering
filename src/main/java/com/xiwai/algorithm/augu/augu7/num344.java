package com.xiwai.algorithm.augu.augu7;

public class num344 {
    public static void main(String[] args) {
        Solution344 solution344 = new Solution344();
        char[] s = {'h', 'e', 'l', 'o', 'a'};
        solution344.reverseString(s);
        for (char i : s) {
            System.out.println(i);
        }
    }
}


class Solution344 {
    public void reverseString(char[] s) {
        int slowIndex = 0;
        for (int fastIndex = s.length - 1; fastIndex>=slowIndex&&fastIndex >= s.length / 2; slowIndex++, fastIndex--) {
            char temp;
            temp = s[fastIndex];
            s[fastIndex] = s[slowIndex];
            s[slowIndex] = temp;
        }

    }
}