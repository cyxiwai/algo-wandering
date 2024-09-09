package com.xiwai.employment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class test5 {
    public static int fx(int x) {
        return Integer.bitCount(x);

    }

    public static int gx(int x) {
        int count = fx(x);
        int temp = x + 1;
        while (fx(temp) != count) {
            temp++;
        }
        return temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n];
        dp[0] = 1;
        int[] queue = new int[n];
        int index = 0;
        while (index < n && sc.hasNextInt()) {
            queue[index++] = sc.nextInt();
        }
        Arrays.sort(queue);
        int ans = 1;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (queue[j] == gx(queue[i])) {
                    dp[j] = dp[i] + 1;
                }
                ans = Math.max(ans, dp[j]);
            }
        }
        System.out.println(ans);
        for (int i = 0; i < 20; i++) {
            System.out.println(gx(i+1));
        }
    }
}
