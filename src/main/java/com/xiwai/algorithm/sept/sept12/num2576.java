package com.xiwai.algorithm.sept.sept12;

import java.util.Arrays;

public class num2576 {
    public static void main(String[] args) {


        Solurion2576 saa = new Solurion2576();
        int[] test = {2, 4, 5, 9};
        saa.maxNumOfMarkedIndices(test);
    }
}

class Solurion2576 {
    public int maxNumOfMarkedIndices(int[] nums) {
//动态规划，转移方程为小于n/2之前的所有的值累加，成为自己的值，复杂度n2
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0, j = nums.length / 2; i < nums.length / 2 && j < nums.length; i++) {
            while (j < nums.length && 2 * nums[i] > nums[j]) {
                j++;

            }
            if (j < nums.length) {
                res += 2;
                j++;
            }
        }
        return res;
    }
}
