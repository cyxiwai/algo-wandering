package com.xiwai.algorithm.augu.augu24;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class num128 {
}

class Solution128 {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Set<Integer> set1 = new HashSet<>();
        int ans = Integer.MIN_VALUE;
        for (int num : nums) {
            set1.add(num);
        }
        for (int num : nums) {
            if (!set1.contains(num - 1)) {
                int count = 1;

                int curNum = num;
                while (set1.contains(curNum + 1)) {
                    curNum += 1;
                    count++;
                }
                ans = Math.max(count, ans);
            }

        }
        return ans;
    }
}