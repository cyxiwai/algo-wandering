package com.xiwai.algorithm.sept.sept2;

import java.util.Arrays;
import java.util.Scanner;

public class kama56 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int bag_size = sc.nextInt();
        int mineral_kind = sc.nextInt();
        int[] mineral_size = new int[mineral_kind];
        int[] mineral_value = new int[mineral_kind];
        int[] mineral_usage = new int[mineral_kind];
        for (int i = 0; i < mineral_kind; i++) {
            mineral_size[i] = sc.nextInt();
        }
        for (int i = 0; i < mineral_kind; i++) {
            mineral_value[i] = sc.nextInt();
        }
        for (int i = 0; i < mineral_kind; i++) {
            mineral_usage[i] = sc.nextInt();
        }
        int sum = 0;
        for (int i = 0; i < mineral_kind; i++) {
            sum += mineral_usage[i];
        }
        mineral_size = Arrays.copyOf(mineral_size, sum);
        mineral_value = Arrays.copyOf(mineral_value, sum);
        int index = mineral_kind;
        for (int i = sum - 1; i >= 0; i--) {
            mineral_size[i] = mineral_size[index - 1];
            mineral_value[i] = mineral_value[index - 1];
            if (--mineral_usage[index - 1] == 0) {
                index--;
            }
        }
        int[] dp = new int[bag_size + 1];
        dp[0] = 0;
        for (int i = 0; i < sum; i++) {
            for (int j = bag_size; j >=mineral_size[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - mineral_size[i]] + mineral_value[i]);
            }
        }
        System.out.println(dp[bag_size]);

        System.out.println();
    }
}
