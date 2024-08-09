package com.xiwai.algorithm.augu9.augu8;

import java.util.Arrays;

public class num151 {
    public static void main(String[] args) {
        Solution151 solution151 = new Solution151();
        String test = "  hello world  ";
        System.out.println(solution151.reverseWords(test));
    }
}


class Solution151 {
    public String reverseWords(String s) {
//        System.out.println(s);
        String res = reverse(deleteDuplicate(trim(s), ' '));
//        System.out.println(res);
        char[] resChar = res.toCharArray();
        int start = 0;
        int end = 0;
        while (end < resChar.length) {
            if (resChar[end] == ' ' || end == resChar.length - 1) {

                int startTemp = start;
                int endTemp = (end == resChar.length - 1) ? end : end - 1;
                start = end + 1;
                while (startTemp < endTemp) {
                    char temp = resChar[endTemp];
                    resChar[endTemp] = resChar[startTemp];
                    resChar[startTemp] = temp;
                    startTemp++;
                    endTemp--;
                }
            }
            end++;

        }
        res = new String(resChar);

        return res;

    }

    private static String deleteDuplicate(String s, char c) {
        char[] sChar = s.toCharArray();
        int slowindex = 0;
        for (int fastindex = 0; fastindex < sChar.length; ) {
            while (fastindex < sChar.length - 1 && sChar[fastindex] == sChar[fastindex + 1]
                    && sChar[fastindex] == c) {
                fastindex++;
            }
            sChar[slowindex++] = sChar[fastindex++];
        }

        return new String(Arrays.copyOfRange(sChar, 0, slowindex));
    }

    private static String reverse(String s) {
        int slowindex = 0;
        char[] sChar = s.toCharArray();
        int fastindex = sChar.length - 1;
        while (slowindex < fastindex) {
            char temp = sChar[fastindex];
            sChar[fastindex] = sChar[slowindex];
            sChar[slowindex] = temp;
            slowindex++;
            fastindex--;
//            sChar[slowindex++]=sChar[fastindex--];
        }
        return new String(sChar);
    }

    private static String trim(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start <= end && s.charAt(start) == ' ') {
            start++;
        }
        while (start <= end && s.charAt(end) == ' ') {
            end--;
        }
        return s.substring(start, end + 1);


    }
}