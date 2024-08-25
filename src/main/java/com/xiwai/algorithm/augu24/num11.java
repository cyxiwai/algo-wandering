package com.xiwai.algorithm.augu24;

public class num11 {
}

class Solution11 {
    public int maxArea(int[] height) {
        int leftIndex = 0;
        int rightIndex = height.length - 1;
        int result = Integer.MIN_VALUE;
        while (leftIndex < rightIndex) {
            int area = (rightIndex - leftIndex) * Math.min(height[leftIndex], height[rightIndex]);
            result = Math.max(result, area);
            if (height[leftIndex] <= height[rightIndex]) {
                leftIndex++;
            } else {
                rightIndex--;
            }
        }
        return result;
    }
}
