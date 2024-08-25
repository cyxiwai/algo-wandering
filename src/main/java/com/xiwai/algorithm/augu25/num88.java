package com.xiwai.algorithm.augu25;

public class num88 {
    public static void main(String[] args) {
        int[] test1 = {0};
        int[] test2 = {2};
//        Solution solution = new Solution();
//        solution.merge(test1, 0, test2, 1);
//        for (int i = 0; i < test1.length; i++) {
//            System.out.println(test1[i]);
        }
    }


class Solution88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int[] ans = new int[m + n];
        int index1 = 0;
        int index2 = 0;
        for (int i = 0; i < m + n; i++) {
            if (index1 == m ) {
                ans[i] = nums2[index2++];
                continue;
            }
            if (index2 == n) {
                ans[i] = nums1[index1++];
                continue;
            }
            if (nums1[index1] <= nums2[index2]) {
                ans[i] = nums1[index1++];
            } else {
                ans[i] = nums2[index2++];
            }
        }
        for (int i = 0; i < m + n; i++) {
            nums1[i] = ans[i];
        }
        return;
    }
}
