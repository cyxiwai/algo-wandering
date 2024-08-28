package com.xiwai.augu28;

public class num42 {
}

class Solution {
    public int trap(int[] height) {
        int[] maxRight = new int[height.length];
        int[] maxLeft = new int[height.length];
        maxLeft[0] = height[0];
        maxRight[maxRight.length - 1] = height[height.length - 1];
        for (int i = 1; i < maxLeft.length; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i]);
        }
        for (int i = maxRight.length - 2; i >= 0; i--) {
            maxRight[i] = Math.max(height[i], maxRight[i + 1]);
        }
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            ans += Math.min(maxLeft[i], maxRight[i]) - height[i];
        }
        return ans;
    }
}