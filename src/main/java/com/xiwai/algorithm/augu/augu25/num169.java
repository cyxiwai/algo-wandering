package com.xiwai.algorithm.augu.augu25;

import java.util.Arrays;

public class num169 {
}

class Solution169 {
    public int majorityElement(int[] nums) {
        int vote_count = 1;
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (vote_count == 0) {
                ans = nums[i];
            }
            if (nums[i] == ans) {
                vote_count += 1;
            }
            if (nums[i] != ans) {
                vote_count -= 1;
            }
        }
        return ans;
    }


}
