package com.xiwai.employment;

import java.util.Arrays;
import java.util.Scanner;

public class septtest2 {
    public static int prime(int[] nums) {
        Arrays.sort(nums);
        if (nums[0] == 1) {
            return -1;
        }
        for (int i = 2; i <= nums[0]; i++) {
            int j = 0;
            for (; j < 4; j++) {
                if (nums[j] % i != 0) {
                    break;
                }
            }
            if (j == 4) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[][] nums = new int[num][4];
        int temp = num;
        while (temp-- > 0) {
            for (int i = 0; i < 4; i++) {
                nums[temp][i] = sc.nextInt();
            }
        }
        for (int i = num - 1; i >= 0; i--) {
            System.out.println(prime(nums[i]));
        }

    }
}
