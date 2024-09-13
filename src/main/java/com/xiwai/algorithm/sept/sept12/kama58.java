package com.xiwai.algorithm.sept.sept12;

import java.util.Scanner;

public class kama58 {
    public static void main(String[] args) {
        int sum = 0;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        int[] sumS = new int[n + 1];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            sumS[i] = sum;
        }
        while (sc.hasNext()) {
            int s = sc.nextInt();
            int t = sc.nextInt();
            if (s == 0) {
                System.out.println(sumS[t]);
            } else {
                System.out.println(sumS[t] - sumS[s - 1]);
            }
        }
    }
}
//前缀和思路 任意0-n区间的值存到一个数组
//需要的时候取出，如区间x，y则取数组y-数组x即可

