package com.xiwai.algorithm.augu.augu25;

public class num27 {
}
class Solution27 {
    public int removeElement(int[] nums, int val) {
    int slowIndex= 0;
        for (int fastindex = 0; fastindex < nums.length;fastindex++) {
            if(nums[fastindex]!=val)
            {
                nums[slowIndex++]=nums[fastindex];
            }
            else {
                continue;
            }

        }
        return slowIndex;
    }
}