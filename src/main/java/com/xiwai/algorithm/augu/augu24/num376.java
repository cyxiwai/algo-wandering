package com.xiwai.algorithm.augu.augu24;

public class num376 {
    public static void main(String[] args) {
        int[] testNums= {1,5,2,6,3,7,7};
//        Solution solution= new Solution();
//        System.out.println(solution.wiggleMaxLength(testNums));

    }
}

class Solution376 {
    public int wiggleMaxLength(int[] nums) {
        int preDiff = 0;
        int curDiff = 0;
        int result = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            curDiff = nums[i + 1] - nums[i];
            if ((preDiff <= 0 && curDiff > 0) || (preDiff >= 0 && curDiff < 0)) {
                result++;
                preDiff = curDiff;
            }
        }
        return result;
    }
}