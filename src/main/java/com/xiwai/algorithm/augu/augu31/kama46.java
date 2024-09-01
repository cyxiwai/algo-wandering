package com.xiwai.algorithm.augu.augu31;

import java.util.Arrays;
import java.util.Scanner;

public class kama46 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int kind_num = sc.nextInt();
        int hold_num = sc.nextInt();
        int[] paper_size = new int[kind_num];
        int[] paper_value = new int[kind_num];

        for (int i = 0; i < kind_num; i++) {
            paper_size[i] = sc.nextInt();

        }
        for (int i = 0; i < kind_num; i++) {
            paper_value[i] = sc.nextInt();
        }
        int[] dp = new int[hold_num + 1];
        for (int i = 0; i < kind_num; i++) {
            for (int j = hold_num; j >=paper_size[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - paper_size[i]] + paper_value[i]);
            }
        }
//
//        int[][] dp = new int[kind_num][hold_num + 1];
//        for (int i = 0; i < kind_num; i++) {
//            dp[i][0] = 0;
//        }
//        for (int i = paper_size[0]; i <= hold_num; i++) {
//            dp[0][i] = paper_value[0];
//        }
//        for (int i = 1; i < kind_num; i++) {
//            for (int j = 0; j <= hold_num; j++) {
//                if (paper_size[j] > j) {
//                    dp[i][j] = dp[i - 1][j];
//                } else {
//                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - paper_size[i]] + paper_value[i]);
//                }
//            }
//        }
        System.out.println(dp[hold_num]);
    }
}
