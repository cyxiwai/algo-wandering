package com.xiwai.algorithm.augu.augu24;

public class num283 {
    public static void main(String[] args) {
        int[] test = {0, 1, 0, 3, 12};
        Solution solution = new Solution();
        solution.moveZeroes(test);
    }
}

class Solution {
    public void moveZeroes(int[] nums) {
        if (nums.length == 0) {
            return;
        }
        int slowIndex = 0;

        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {

            if (nums[fastIndex] == 0) {
                continue;
            } else {
                nums[slowIndex++] = nums[fastIndex];
            }
        }
        for (; slowIndex < nums.length; slowIndex++) {
            nums[slowIndex] = 0;
        }

    }
}
