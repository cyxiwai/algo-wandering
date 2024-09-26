package com.xiwai.algorithm.sept.sept26;

public class num2535 {
}

class Solution2535 {
    public int differenceOfSum(int[] nums) {
        int sum = 0;
        int realSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 9) {
                sum += bitSum(nums[i]);
            } else {
                sum += nums[i];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            realSum += nums[i];
        }
        return realSum - sum;
    }

    public int bitSum(int x) {
        int sum = 0;
        while (x > 0) {
            sum += (x % 10);
            x /= 10;
        }
        return sum;
    }
}
