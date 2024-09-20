package com.xiwai.algorithm.sept.sept18;

import java.util.Scanner;

public class kama54_second {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int len = s.length();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                len += 5;
            }
        }
        char[] ans = new char[len];
        for (int i = 0; i < s.length(); i++) {
            ans[i] = s.charAt(i);
        }
        for (int i = s.length() - 1, j = len - 1; i >= 0; i--) {
            if (ans[i] >= '0' && ans[i] <= '9') {
                ans[j--] = 'r';
                ans[j--] = 'e';
                ans[j--] = 'b';
                ans[j--] = 'm';
                ans[j--] = 'u';
                ans[j--] = 'n';
            } else {
                ans[j--] = ans[i];
            }
        }
        System.out.println(ans);
    }
}
