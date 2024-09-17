package com.xiwai.employment;

import java.util.Scanner;

public class JDtest1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] nums = new int[size];
        long sum = 0;
        long[] preFix = new long[size];
        for (int i = 0; i < size; i++) {
            nums[i] = sc.nextInt();
            sum += nums[i];
            preFix[i] = sum;
        }
        long ans = Long.MAX_VALUE;
        for (int i = 0; i < size - 1; i++) {
            ans = Math.min(ans, Math.abs((sum - preFix[i]) * preFix[i]));
        }
        System.out.println(ans);
    }
}
