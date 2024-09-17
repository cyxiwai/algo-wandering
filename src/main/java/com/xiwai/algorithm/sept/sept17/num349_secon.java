package com.xiwai.algorithm.sept.sept17;

import java.util.HashSet;

public class num349_secon {
}

class Solution349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (set1.contains(nums2[i])) {
                set2.add(nums2[i]);
            }
        }
        int[] ans = new int[set2.size()];
        int index = 0;
        for (int i : set2) {
            ans[index++] = i;
        }
        return ans;
    }
}
