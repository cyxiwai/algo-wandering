package com.xiwai.algorithm.augu24;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class num1 {
}

class Solution1 {
    int[] ans = new int[2];
    HashMap<Integer, Integer> map = new HashMap<>();

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (map.containsValue(target - nums[i])) {
                for (Map.Entry<Integer, Integer> map : map.entrySet()) {
                    if (map.getValue() == target) {
                        ans[0] = map.getKey();
                        ans[1] = i;
                    }
                }
            }
            map.put(i, nums[i]);

        }
        return ans;
    }
}
