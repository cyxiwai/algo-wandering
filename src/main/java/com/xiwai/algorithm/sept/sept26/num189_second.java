package com.xiwai.algorithm.sept.sept26;

public class num189_second {
    public static void main(String[] args) {

    }
}

class Solution189 {
    public void rotate(int[] nums, int k) {
        reverse(0, nums.length - 1, nums);
        reverse(0, k - 1, nums);
        reverse(k, nums.length - 1, nums);
    }

    public void reverse(int start, int end, int[] nums) {
        int left = start;
        int right = end;
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
        return;
    }
}
