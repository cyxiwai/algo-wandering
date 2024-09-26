package com.xiwai.algorithm.sept.sept26;

import java.util.Arrays;

public class num238 {
    public static void main(String[] args) {
        Solution238 s = new Solution238();
        int[] test = {-1, -1, 0, 3, 3};
        for (int i = 0; i < test.length; i++) {
            System.out.println(s.productExceptSelf(test)[i]);
        }
    }
}

class Solution238 {
    public int[] productExceptSelf(int[] nums) {
        int[] pre = new int[nums.length];
        int[] post = new int[nums.length];
        Arrays.fill(pre, 1);
        Arrays.fill(post, 1);
        int preStar = 1;
        int postStar = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == 0) {
                for (int j = i; j < nums.length; j++) {
                    pre[j] = 0;
                }
                break;
            }
            preStar *= nums[i - 1];
            pre[i] = preStar;
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i + 1] == 0) {
                for (int j = i; j >= 0; j--) {
                    post[j] = 0;
                }
                break;
            }
            postStar *= nums[i + 1];
            post[i] = postStar;
        }
        int[] ans = new int[nums.length];
        for (int i = 1; i < ans.length - 1; i++) {
            ans[i] = pre[i] * post[i];
        }
        ans[0] = post[0];
        ans[nums.length - 1] = pre[nums.length - 1];
        return ans;
    }
}
