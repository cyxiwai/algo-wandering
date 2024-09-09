package com.xiwai.employment;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //思路，累计奇数个数和偶数个数，奇数偶数求和分别加个数取小值即可。
        int size = sc.nextInt();
        long[] nums = new long[size];
        int odd_count = 0;
        int st_count = 0;
        long odd_sum = 0;
        long st_sum = 0;
        for (int i = 0; i < size; i++) {
            nums[i] = sc.nextLong();
            if (nums[i] % 2 == 0) {
                odd_sum += nums[i];
                odd_count++;
            } else {
                st_sum += nums[i];
                st_count++;
            }
        }
        System.out.println(Math.min(odd_sum + odd_count, st_sum + st_count));
    }
}
