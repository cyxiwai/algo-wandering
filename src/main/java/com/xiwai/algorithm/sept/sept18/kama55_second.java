package com.xiwai.algorithm.sept.sept18;

import java.util.Scanner;

public class kama55_second {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        char[] sChar = s.toCharArray();
        reverse(sChar, 0, sChar.length - 1);
        reverse(sChar, 0, n - 1);
        reverse(sChar, n, sChar.length - 1);
        System.out.println(new String(sChar));
    }

    public static void reverse(char[] chars, int left, int right) {
        if (right >= chars.length) {
            System.out.println("wrong input");
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
}
