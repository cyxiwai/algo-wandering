//package com.xiwai.algorithm.augu25;
//
//public class num80 {
//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        int[] test = {1, 1, 1, 2, 2, 3};
//        System.out.println(solution.removeDuplicates(test));
//    }
//}
//
//class Solution80 {
//    public int removeDuplicates(int[] nums) {
//        int count = 1;
//        int slowIndex = 1;
//        for (int fastIndex = 1; fastIndex < nums.length; fastIndex++) {
//            if (nums[fastIndex] == nums[fastIndex - 1]) {
//                count++;
//            } else {
//                count = 1;
//            }
//            if (count <= 2) {
//                nums[slowIndex++] = nums[fastIndex];
//            }
//        }
//        return slowIndex;
//    }
//}