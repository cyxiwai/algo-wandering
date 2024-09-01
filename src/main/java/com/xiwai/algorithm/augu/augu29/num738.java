package com.xiwai.algorithm.augu.augu29;

public class num738 {
    public static void main(String[] args) {
        Solution738 Solution738 = new Solution738();
        System.out.println(Solution738.monotoneIncreasingDigits(103));
    }
}

class Solution738 {
    public int monotoneIncreasingDigits(int n) {

        int bit = Math.max(1, bit(n));
        int[] nums = get_bit(n, bit);
        int[] ans = new int[nums.length];
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i - 1] > nums[i]) {
                for (int j = i; j < nums.length; j++) {
                    nums[j] = 9;
                }
                nums[i - 1]--;
            }
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            int times = nums.length - i - 1;
            int temp = (int) Math.pow(10, times);
            sum += nums[i] * temp;
        }
        return sum;
    }

    public int[] get_bit(int n, int bit) {
        int[] nums = new int[bit];
        int index = bit - 1;
        while (n >= 10) {
            nums[index--] = n % 10;
            n /= 10;
        }
        nums[index] = n;
        return nums;
    }

    public int bit(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n /= 10;
        }
        return count;
    }
}
