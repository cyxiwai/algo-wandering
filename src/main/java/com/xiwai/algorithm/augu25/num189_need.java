//package com.xiwai.algorithm.augu25;
//
//public class num189 {
//    public static void main(String[] args) {
//        int[] test = {1, 2, 3, 4};
//        Solution solution = new Solution();
//        solution.rotate(test, 2);
//    }
//}
//
//class Solution189 {
//    public void rotate(int[] nums, int k) {
//        if (k > nums.length) {
//            k %= nums.length;
//        }
//        int slowIndex = 0;
//        int[] ans = new int[nums.length];
//        for (int fastIndex = nums.length - k; fastIndex < nums.length; fastIndex++) {
//            ans[slowIndex++] = nums[fastIndex];
//        }
//        for (int i = 0; i < nums.length - k; i++) {
//            ans[slowIndex++] = nums[i];
//
//        }
//        System.arraycopy(ans, 0, nums, 0, nums.length);
//        return;
//    }
//
//}
