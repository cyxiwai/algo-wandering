package com.xiwai.algorithm.sept.sept1;

import java.util.Scanner;

public class kama52 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int paper_kind = sc.nextInt();
        int bag_size = sc.nextInt();
        int[] paper_value = new int[paper_kind];
        int[] paper_size = new int[paper_kind];
        for (int i = 0; i < paper_kind; i++) {
            paper_size[i] = sc.nextInt();
            paper_value[i] = sc.nextInt();
        }

        int[] dp = new int[bag_size + 1];
        for (int i = 0; i < paper_kind; i++) {
            for (int j = 0; j <= bag_size; j++) {
                if (j >= paper_size[i]) {
                    dp[j] = Math.max(dp[j], dp[j - paper_size[i]] + paper_value[i]);
                }
            }
        }
        System.out.println(dp[bag_size]);
    }
}

