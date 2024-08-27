package com.xiwai.algorithm.augu27;

public class num238 {
    public static void main(String[] args) {
        Solution238 solution238 = new Solution238();
        int[] test = {1, 2, 3, 4};
        solution238.productExceptSelf(test);
    }
}

class Solution238 {
    public int[] productExceptSelf(int[] nums) {
        int[] pre = new int[nums.length];
        pre[0] = 1;
        int[] suf = new int[nums.length];
        suf[nums.length - 1] = 1;
        int[] ans = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            pre[i] = pre[i - 1] * nums[i - 1];
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            suf[i] = suf[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < nums.length; i++) {
            ans[i] = pre[i] * suf[i];
        }
//        ans[0]=suf[1];
//        ans[nums.length-1]=pre[nums.length-2];
        return ans;
    }
}