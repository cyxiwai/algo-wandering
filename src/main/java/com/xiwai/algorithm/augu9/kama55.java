package com.xiwai.algorithm.augu9;

//
//字符串的右旋转操作是把字符串尾部的若干个字符转移到字符串的前面。
//给定一个字符串 s
//和一个正整数 k，请编写一个函数，
//将字符串中的后面 k
//个字符移到字符串的前面，实现字符串的右旋转操作。
//例如，对于输入字符串 "abcdefg"和整数 2，函数应该将其转换为 "fgabcde"。
//输入共包含两行，
//第一行为一个正整数 k，代表右旋转的位数。
//第二行为字符串 s，代表需要旋转的字符串。

import java.util.Scanner;

public class kama55 {
    public static void main(String[] args) {
        Solutionkama55 solutionkama55 = new Solutionkama55();
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        String test = sc.next();
        System.out.println(solutionkama55.reverseindex(test, i));
    }
}

class Solutionkama55 {
    public String reverseindex(String s, int i) {
        String res = reverse(s, 0, s.length() - 1);
        String restemp = reverse(res, 0, i - 1);
        res = reverse(restemp, i, s.length() - 1);

        return res;
    }

    private static String reverse(String s, int start, int end) {
        char[] sChar = s.toCharArray();
        while (start < end) {
            char temp = sChar[end];
            sChar[end] = sChar[start];
            sChar[start] = temp;
            start++;
            end--;
        }
        return new String(sChar);
    }
}